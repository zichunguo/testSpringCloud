package com.guo.cloud.controller;

import com.guo.cloud.domain.CommonResult;
import com.guo.cloud.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author guo
 * @date 2020/8/23
 */
@RestController
public class AccountController {

	@Resource
	private AccountService accountService;

	@GetMapping("/account/decrease")
	public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
		accountService.decrease(userId, money);
		return new CommonResult(200, "扣减账户余额成功");
	}

	@GetMapping("/tx/test")
	public String test() {
		accountService.test();
		return "^_^";
	}
}
