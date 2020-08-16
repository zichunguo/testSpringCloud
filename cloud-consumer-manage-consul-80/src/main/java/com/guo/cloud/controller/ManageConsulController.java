package com.guo.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/15
 */
@RestController
@Slf4j
public class ManageConsulController {

	public static final String INVOKE_URL = "http://cloud-user-service";

	@Resource
	private RestTemplate restTemplate;

	/**
	 * 消费方测试接口，获取服务端口
	 * @return
	 */
	@GetMapping("/consumer/user/consul")
	public String testConsulInfo() {
		return restTemplate.getForObject(INVOKE_URL + "/user/consul", String.class);
	}
}
