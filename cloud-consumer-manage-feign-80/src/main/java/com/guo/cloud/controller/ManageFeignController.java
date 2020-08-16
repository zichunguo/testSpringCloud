package com.guo.cloud.controller;

import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import com.guo.cloud.service.UserFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/16
 */
@RestController
public class ManageFeignController {

	@Resource
	private UserFeignService userFeignService;

	/**
	 * 根据 id 查询用户，测试 OpenFeign 方式调用
	 * @param id
	 * @return
	 */
	@GetMapping("/manage/user/get/{id}")
	public CommonResult<User> getById(@PathVariable("id") int id) {
		return userFeignService.getById(id);
	}

	/**
	 * 测试 feign 请求超时
	 * @return
	 */
	@GetMapping("/manage/user/feign/timeout")
	public String testFeignTimeout() {
		// openfeign - ribbon 客户端默认请求等待 1 秒钟
		return userFeignService.testFeignTimeout();
	}

}
