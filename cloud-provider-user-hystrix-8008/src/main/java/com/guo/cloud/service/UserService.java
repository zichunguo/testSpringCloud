package com.guo.cloud.service;

/**
 * 测试 hystrix - 服务降级、服务熔断，简单的定义两个方法，用于测试
 */
public interface UserService {

	/**
	 * 测试正常接口
	 * @param id
	 * @return
	 */
	public String userInfoOK(Integer id);

	/**
	 * 测试超时接口
	 * @param id
	 * @return
	 */
	public String userInfoTimeOut(Integer id);

	/**
	 * 测试服务熔断接口
	 * @param id
	 * @return
	 */
	public String userCircuitBreaker(Integer id);
}
