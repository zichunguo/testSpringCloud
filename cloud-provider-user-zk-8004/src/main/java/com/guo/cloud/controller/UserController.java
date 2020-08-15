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
public class UserController {

	@Value("${server.port}")
	private String serverPort;

	@RequestMapping("/user/zk")
	public String userZK() {
		return "SpringCloud with Zookeeper. serverPort: " + serverPort + ". UUID: " + UUID.randomUUID().toString();
	}

}
