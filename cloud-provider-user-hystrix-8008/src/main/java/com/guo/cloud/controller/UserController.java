package com.guo.cloud.controller;

import com.guo.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/16
 */
@RestController
@Slf4j
public class UserController {

	@Resource
	private UserService userService;

	@Value("${server.port}")
	private String serverPort;

	/**
	 * 测试正常接口
	 * @param id
	 * @return
	 */
	@GetMapping("/user/hystrix/ok/{id}")
	public String userInfoOK(@PathVariable("id") Integer id) {
		String result = userService.userInfoOK(id);
		log.info("userInfoOK. result：" + result);
		return result;
	}

	/**
	 * 测试超时接口
	 * @param id
	 * @return
	 */
	@GetMapping("/user/hystrix/timeout/{id}")
	public String userInfoTimeOut(@PathVariable("id") Integer id) {
		String result = userService.userInfoTimeOut(id);
		log.info("userInfoTimeOut. result：" + result);
		return result;
	}

	// ====== 服务熔断 ======
	/**
	 * 测试服务熔断接口
	 * @param id
	 * @return
	 */
	@GetMapping("/user/hystrix/circuit/{id}")
	public String userCircuitBreaker(@PathVariable("id") Integer id) {
		String result = userService.userCircuitBreaker(id);
		log.info("userCircuitBreaker. result: " + result);
		return result;
	}

}
