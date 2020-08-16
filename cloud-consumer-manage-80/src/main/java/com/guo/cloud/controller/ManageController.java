package com.guo.cloud.controller;

import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import com.guo.cloud.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * 消费方 Controller
 * @author guo
 * @date 2020/8/14
 */
@RestController
@Slf4j
public class ManageController {

	// 单机版时，REST 请求地址，直连的方式请求指定的主机端口
//	public static final String USER_URL = "http://localhost:8001";
	// 集群时，REST 请求地址，使用 Eureka 的服务地址，通过 Eureka 来指定具体请求的服务
	public static final String USER_URL = "http://CLOUD-USER-SERVICE";

	public static final String TEST_URL = "http://CLOUD-TEST-SERVICE";

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private DiscoveryClient discoveryClient;

	@Resource
	private MyLoadBalance myLoadBalance;

	/**
	 * 添加用户--（CLOUD-USER-SERVICE）
	 * @param user
	 * @return
	 */
	@PostMapping("/manage/user/add")
	public CommonResult add(User user){
		String url = USER_URL + "/user/add";
		log.info(user.getName());
		return restTemplate.postForObject(url, user, CommonResult.class);
	}

	/**
	 * 根据 ID 查找用户--（CLOUD-USER-SERVICE）
	 * @param id
	 * @return
	 */
	@GetMapping("/manage/user/get/{id}")
	public CommonResult<User> getById(@PathVariable("id") int id) {
		String url = USER_URL + "/user/get/" + id;
		return restTemplate.getForObject(url, CommonResult.class);
	}

	/**
	 * 测试 restTemplate.getForEntity 方法
	 * 1、restTemplate.getForObject：返回对象为响应体中数据转化成的对象，基本上可以理解为 Json
	 * 2、restTemplate.getForEntity：返回对象为 ResponseEntity 对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等。
	 * @param id
	 * @return
	 */
	@GetMapping("/manage/user/getForEntity/{id}")
	public CommonResult<User> getById2(@PathVariable("id") int id) {
		String url = USER_URL + "/user/get/" + id;
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(url, CommonResult.class);
		if (entity.getStatusCode().is2xxSuccessful()) {
			log.info("status code: " + entity.getStatusCode());
			return entity.getBody();
		} else {
			return new CommonResult<>(444, "查询失败");
		}
	}

	/**
	 * 查询所有用户--（CLOUD-USER-SERVICE）
	 * @return
	 */
	@GetMapping("/manage/user/list")
	public CommonResult<List<User>> list() {
		String url = USER_URL + "/user/list";
		return restTemplate.getForObject(url, CommonResult.class);
	}

	/**
	 * 获取测试服务端口--（CLOUD-TEST-SERVICE）
	 * @return
	 */
	@GetMapping("/manage/test/port")
	public String getDept() {
		String url = TEST_URL + "/test/port";
		return restTemplate.getForObject(url, String.class);
	}

	/**
	 *
	 * 测试自定义的负载均衡算法，轮询（纯自定义，不是使用 Ribbon 自定义配置的方式）--（CLOUD-USER-SERVICE）
	 * 注意：使用自定义负载均衡是需要注释配置类中 RestTemplate 上的 @LoadBalanced 注解
	 * @return
	 */
	@GetMapping("/manage/user/port/lb")
	public String testUserPortLB() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-USER-SERVICE");
		if (instances == null || instances.size() <= 0) {
			return null;
		}
		System.out.println(instances);
		ServiceInstance serviceInstance = myLoadBalance.instance(instances);
		URI uri = serviceInstance.getUri();
		String url = uri + "/user/port";
		return restTemplate.getForObject(url, String.class);
	}

}
