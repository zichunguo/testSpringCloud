package com.guo.cloud.controller;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 sleuth + zipkin 分布式请求链路跟踪
 * @author guo
 * @date 2020/8/20
 */
@RestController
public class SleuthProviderController {

	@GetMapping("/sleuth/zikpin")
	public String testZipkin() {
		return "(*^▽^*)";
	}
}
