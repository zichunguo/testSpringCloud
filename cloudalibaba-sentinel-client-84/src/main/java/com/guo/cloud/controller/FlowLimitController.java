package com.guo.cloud.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author guo
 * @date 2020/8/22
 */
@RestController
public class FlowLimitController {
	@Resource
	private RestTemplate restTemplate = new RestTemplate();

	private String serverURL = "http://sentinel-service";

	@GetMapping("/testC")
	public String testC() {
		return restTemplate.getForObject(serverURL + "/testA", String.class);
	}
}
