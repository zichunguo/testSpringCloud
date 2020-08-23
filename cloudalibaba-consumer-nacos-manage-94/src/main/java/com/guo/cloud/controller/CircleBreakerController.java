package com.guo.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import com.guo.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/23
 */
@RestController
@Slf4j
public class CircleBreakerController {

	@Value("${server-url.nacos-provider-service}")
	private String service_url;

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer/fallback/{id}")
//	@SentinelResource(value = "fallback") // 没有配置
//	@SentinelResource(value = "fallback", fallback = "fallbackHandler") // 只配 fallback，负责程序中异常时的处理
//	@SentinelResource(value = "fallback", blockHandler = "blockHandler") // 只配 blockHandler，负责 Sentinel 控制台配置限流处理
	@SentinelResource(value = "fallback", fallback = "fallbackHandler", blockHandler = "blockHandler") // 全配置
//	@SentinelResource(value = "fallback", fallback = "fallbackHandler", blockHandler = "blockHandler",
//			exceptionsToIgnore = {IllegalArgumentException.class}) // 配置忽略属性，会忽略 IllegalArgumentException 这个异常
	public CommonResult<User> fallback(@PathVariable Integer id) {
		CommonResult result = restTemplate.getForObject(service_url + "/get/user/" + id, CommonResult.class);
		if (id == 4) {
			throw new IllegalArgumentException("IllegalArgumentException. 非法参数异常...");
		} else if (result.getData() == null) {
			throw new NullPointerException("NullPointerException. 该 ID 没有对应记录. 空指针异常...");
		}
		return result;
	}

	public CommonResult<User> fallbackHandler(@PathVariable Integer id, Throwable e) {
		User user = new User(id, "null");
		return new CommonResult<>(444, "o(╥﹏╥)o 程序异常 - fallbackHandler. exception: " + e.getMessage(), user);
	}

	public CommonResult<User> blockHandler(@PathVariable Integer id, BlockException exception) {
		User user = new User(id, "null");
		return new CommonResult<>(445, "o(╥﹏╥)o 限流 - blockHandler. BlockException: " + exception.getClass().getCanonicalName(), user);
	}

	// ========= openFeign ==========
	@Resource
	private UserService userService;

	@GetMapping("/consumer/openFeign/{id}")
	public CommonResult<User> testOpenFeign(@PathVariable Integer id) {
		return userService.getUser(id);
	}

}
