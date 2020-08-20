package com.guo.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 测试 sleuth + zipkin 分布式请求链路跟踪
 * @author guo
 * @date 2020/8/20
 */
@RestController
public class SleuthConsumerController {
	public static final String SERVICE_URL = "http://CLOUD-SLEUTH-SERVICE";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer/sleuth/zikpin")
	public String testZipKin() {
		return restTemplate.getForObject(SERVICE_URL + "/sleuth/zikpin", String.class);
	}
}
