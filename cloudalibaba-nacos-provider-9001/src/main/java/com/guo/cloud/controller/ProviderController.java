package com.guo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos 服务提供方的测试 Controller 类
 * @author guo
 * @date 2020/8/21
 */
@RestController
public class ProviderController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/nacos/{id}")
	public String testNacos(@PathVariable("id") Integer id) {
		return "Nacos Discovery. serverPort: " + serverPort + ". id: " + id;
	}

}
