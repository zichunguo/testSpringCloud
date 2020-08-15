package com.guo.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/15
 */
@RestController
public class ManageZKController {

	public static final String INVOKE_URL = "http://cloud-user-service";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer/user/zk")
	public String testZKInfo() {
		return restTemplate.getForObject(INVOKE_URL + "/user/zk", String.class);
	}
}
