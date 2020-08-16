package com.guo.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guo
 * @date 2020/8/16
 */
@Component
@FeignClient(value = "CLOUD-USER-SERVICE-HYSTRIX", fallback = UserHystrixFallback.class)
public interface UserHystrixService {

	/**
	 * 测试正常接口
	 * @param id
	 * @return
	 */
	@GetMapping("/user/hystrix/ok/{id}")
	public String userInfoOK(@PathVariable("id") Integer id);

	/**
	 * 测试超时接口
	 * @param id
	 * @return
	 */
	@GetMapping("/user/hystrix/timeout/{id}")
	public String userInfoTimeOut(@PathVariable("id") Integer id);

	/**
	 * 测试服务降级接口
	 * @param id
	 * @return
	 */
	@GetMapping("/user/hystrix/circuit/{id}")
	public String userCircuitBreaker(@PathVariable("id") Integer id);

}
