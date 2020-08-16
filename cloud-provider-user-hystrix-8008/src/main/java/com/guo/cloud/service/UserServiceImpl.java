package com.guo.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 测试 hystrix - 服务降级、服务熔断，简单的定义两个方法，用于测试
 * @author guo
 * @date 2020/8/16
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public String userInfoOK(Integer id) {
		return "userInfoOK. id：" + id + ". 线程池：" + Thread.currentThread().getName() + ". O(∩_∩)O";
	}

	@Override
	// 在 HystrixCommandProperties 类中查看配置参数
	// 当方法报错或超时后都会去执行 userInfoTimeOutHandler 方法
	@HystrixCommand(fallbackMethod = "userInfoTimeOutHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")// 设置超时时间
	})
	public String userInfoTimeOut(Integer id) {
//		int i = 10 / 0;// 测试异常情况
		// 测试服务超时情况
		int timeNumber = 2;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "userInfoTimeOut. id：" + id + ". 线程池：" + Thread.currentThread().getName() + ". O(∩_∩)O";
	}

	/**
	 * 上面方法异常或超时后，服务降级，调用的方法 fallbackMethod
	 * @param id
	 * @return
	 */
	public String userInfoTimeOutHandler(Integer id) {
		return "userInfoTimeOutHandler. id：" + id + ". 线程池：" + Thread.currentThread().getName() + ". 8008 服务忙，请稍后再试. o(╥﹏╥)o";
	}

	// ====== 服务熔断 ======
	@Override
	@HystrixCommand(fallbackMethod = "userCircuitBreakerFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器，默认 true
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数，默认 20
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期，默认 5000
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸，默认 50
	})
	// 默认是开启服务熔断的，只是参数配置问题
//	@HystrixCommand(fallbackMethod = "userCircuitBreakerFallback")
	public String userCircuitBreaker(Integer id) {
		if (id < 0) {
			throw new RuntimeException("*** id 不能为负 ***");
		}
		String uuid = IdUtil.simpleUUID();
		return "userCircuitBreaker. id：" + id + ". 线程池：" + Thread.currentThread().getName() + ". uuid: " + uuid + ". O(∩_∩)O";
	}

	/**
	 * 上面方法异常或超时后，服务降级，调用的方法 fallbackMethod
	 * @param id
	 * @return
	 */
	public String userCircuitBreakerFallback(Integer id) {
		return "id 不能为负，请稍后再试。o(╥﹏╥)o " + "id: " + id;
	}

}
