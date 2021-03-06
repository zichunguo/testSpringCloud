package com.guo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guo
 * @date 2020/8/20
 */
@RestController
@RefreshScope
public class ConfigClientController {
	@Value("${server.port}")
	private String serverPort;

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/config/info")
	public String getConfigInfo() {
		return "serverPort: " + serverPort + ". info: " + configInfo;
	}
}
