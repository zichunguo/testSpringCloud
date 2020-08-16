package com.guo.cloud.service;

import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guo
 * @date 2020/8/16
 */
@Component
@FeignClient(value = "CLOUD-USER-SERVICE")
public interface UserFeignService {

	@GetMapping("/user/get/{id}")
	public CommonResult<User> getById(@PathVariable("id") int id);

	@GetMapping("/user/feign/timeout")
	public String testFeignTimeout();

}
