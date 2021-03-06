package com.guo.cloud.controller;

import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import com.guo.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author guo
 * @date 2020/8/14
 */
@RestController
@Slf4j
public class UserController {

	@Resource
	private UserService userService;

	@Resource
	private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	private String serverPort;

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@PostMapping("/user/add")
	public CommonResult add(@RequestBody User user){
		int result = userService.add(user);
		log.info("插入结果：" + result);
		if (result > 0) {
			return new CommonResult(200, "添加成功, serverPort: " + serverPort, result);
		} else {
			return new CommonResult(444,"插入失败");
		}
	}

	/**
	 * 根据 ID 查找用户
	 * @param id
	 * @return
	 */
	@GetMapping("/user/get/{id}")
	public CommonResult<User> getById(@PathVariable("id") int id) {
		User user = userService.getById(id);
		if (user != null) {
			return new CommonResult(200, "查询成功, serverPort: " + serverPort, user);
		} else {
			return new CommonResult(444,"查询失败，ID：" + id);
		}
	}

	/**
	 * 查询所有用户
	 * @return
	 */
	@GetMapping("/user/list")
	public CommonResult<List<User>> list() {
		List<User> list = userService.list();
		if (list != null) {
			return new CommonResult(200, "查询成功, serverPort: " + serverPort, list);
		} else {
			return new CommonResult(444,"查询失败", null);
		}
	}

	/**
	 * 服务发现接口
	 * @return
	 */
	@GetMapping("/user/discovery")
	public Object discovery() {
		// 注册表中的服务列表
		List<String> services = discoveryClient.getServices();
		log.info("services: " + services);
		// 某一服务中的实例列表
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-USER-SERVICE");
		log.info("instances: " + instances);
		for (ServiceInstance instance : instances) {
			log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
		}
		return this.discoveryClient;
	}

	/**
	 * 返回服务端口号接口
	 * @return
	 */
	@GetMapping("/user/port")
	public String getServerPort() {
		return serverPort;
	}

	/**
	 * 测试 feign 请求超时
	 * @return
	 */
	@GetMapping("/user/feign/timeout")
	public String testFeignTimeout() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return serverPort;
	}
}
