package com.guo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author guo
 * @date 2020/8/16
 */
@RestController
public class TestController {

	@Value("${server.port}")
	private String serverPort;

	/**
	 * 测试端口号接口
	 * @return
	 */
	@GetMapping("/test/port")
	public String testPort() {
		return "SpringCloud Test. serverPort: " + serverPort + ". UUID: " + UUID.randomUUID().toString();
	}
}
