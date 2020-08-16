package com.guo.cloud.controller;

import com.guo.cloud.service.UserHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试 HystrixCommand 服务降级
 * @author guo
 * @date 2020/8/16
 */
@RestController
// 使用注解 @DefaultProperties 统一处理服务降级，避免每个方法逐一处理代码膨胀，方法上要加注解 @HystrixCommand
@DefaultProperties(defaultFallback = "userGlobalFallbackMethod")
public class ManagerHystrixController {

	@Resource
	private UserHystrixService userHystrixService;

	/**
	 * 测试正常接口
	 * @param id
	 * @return
	 */
	@GetMapping("/manage/user/hystrix/ok/{id}")
	public String userInfoOK(@PathVariable("id") Integer id) {
		String result = userHystrixService.userInfoOK(id);
		return result;
	}

	/**
	 * 测试超时接口
	 * @param id
	 * @return
	 */
	@GetMapping("/manage/user/hystrix/timeout/{id}")
	// 服务降级，单独处理，由于要每个方法逐一处理，会导致代码膨胀，建议使用全局处理，只有在特殊情况要单独处理时使用单独处理
//	@HystrixCommand(fallbackMethod = "userInfoTimeOutFallbackMethod", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")// 设置超时时间
//	})
	@HystrixCommand
	public String userInfoTimeOut(@PathVariable("id") Integer id) {
		int i = 10 / 0;// 测试异常情况
		String result = userHystrixService.userInfoTimeOut(id);
		return result;
	}

	/**
	 * 上面方法异常或超时后，服务降级，调用的方法 fallbackMethod
	 * @param id
	 * @return
	 */
	public String userInfoTimeOutFallbackMethod(@PathVariable("id") Integer id) {
		return "80. 服务繁忙，请稍后重试。o(╥﹏╥)o";
	}

	/**
	 * 服务降级，全局的 fallbackMethod
	 * @return
	 */
	public String userGlobalFallbackMethod() {
		return "Global. 服务繁忙，请稍后重试。o(╥﹏╥)o";
	}


	/**
	 * 测试服务熔断接口
	 * 客户端测试服务熔断是，需要注释服务端的 @HystrixCommand
	 * @param id
	 * @return
	 */
	@GetMapping("/manage/user/hystrix/circuit/{id}")
	public String userCircuitBreaker(@PathVariable("id") Integer id) {
		return userHystrixService.userCircuitBreaker(id);
	}

}
