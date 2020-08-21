package com.guo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/21
 */
@RestController
public class ConsumerController {

	@Resource
	private RestTemplate restTemplate;

	@Value("${server-url.nacos-provider-service}")
	private String serverURL;

	@GetMapping("/consumer/nacos/{id}")
	public String testNacos(@PathVariable("id") Integer id) {
		return restTemplate.getForObject(serverURL + "/nacos/" + id, String.class);
	}
}
