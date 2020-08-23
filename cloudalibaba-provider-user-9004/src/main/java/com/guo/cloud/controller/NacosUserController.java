package com.guo.cloud.controller;

import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author guo
 * @date 2020/8/23
 */
@RestController
public class NacosUserController {

	@Value("${server.port}")
	private String serverPort;

	public static HashMap<Integer, User> userMap = new HashMap<>();

	static {
		userMap.put(1, new User(1, "zhangsan"));
		userMap.put(2, new User(2, "lisi"));
		userMap.put(3, new User(3, "wangwu"));
	}

	@GetMapping(value = "/get/user/{id}")
	public CommonResult<User> getUser(@PathVariable("id") Integer id) {
		User user = userMap.get(id);
		CommonResult<User> result = new CommonResult<>(200, "success. serverPort: " + serverPort, user);
		return result;
	}

}
