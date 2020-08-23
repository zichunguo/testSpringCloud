package com.guo.cloud.service;

import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guo
 * @date 2020/8/23
 */
@FeignClient(value = "nacos-user-provider", fallback = UserFallBackService.class)
public interface UserService {
	@GetMapping(value = "/get/user/{id}")
	CommonResult<User> getUser(@PathVariable("id") Integer id);
}
