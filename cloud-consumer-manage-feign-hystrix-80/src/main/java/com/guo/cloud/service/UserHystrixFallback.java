package com.guo.cloud.service;

import com.guo.cloud.service.UserHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author guo
 * @date 2020/8/16
 */
@Component
public class UserHystrixFallback implements UserHystrixService {
	@Override
	public String userInfoOK(Integer id) {
		return "UserHystrixFallbackService. userInfoOK. fall back. o(╥﹏╥)o";
	}

	@Override
	public String userInfoTimeOut(Integer id) {
		return "UserHystrixFallbackService. userInfoTimeOut. fall back. o(╥﹏╥)o";
	}

	@Override
	public String userCircuitBreaker(Integer id) {
		return "UserHystrixFallbackService. userCircuitBreaker. fall back. o(╥﹏╥)o id：" + id;
	}
}
