package com.guo.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author guo
 * @date 2020/8/15
 */
@RestController
@Slf4j
public class ManageConsulController {

	@Value("${server.port}")
	private String serverPort;

	/**
	 * 测试接口，返回服务端口号
	 * @return
	 */
	@RequestMapping("/user/consul")
	public String userConsul() {
		return "SpringCloud with Consul. serverPort: " + serverPort + ". UUID: " + UUID.randomUUID().toString();
	}
}
