package com.guo.cloud.service;

import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author guo
 * @date 2020/8/23
 */
@Service
public class UserFallBackService implements UserService {
	@Override
	public CommonResult<User> getUser(Integer id) {
		return new CommonResult<>(447, "o(╥﹏╥)o 服务降级 - UserFallBackService. userFeign.", new User(id, "error"));
	}
}
