package com.guo.cloud.controller;

import com.guo.cloud.domain.CommonResult;
import com.guo.cloud.service.AccountService;
import com.guo.cloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author guo
 * @date 2020/8/27
 */
@RestController
public class PaymentController {

	@Resource
	private AccountService accountService;
	@Resource
	private StorageService storageService;

	@GetMapping("/payment/storage/decrease")
	public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
		storageService.decrease(productId, count);
		return new CommonResult(200, "扣减库存成功");
	}

	@GetMapping("/payment/account/decrease")
	public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
		accountService.decrease(userId, money);
		return new CommonResult(200, "扣减账户余额成功");
	}

	@GetMapping("/tx/test")
	public String test() {
		storageService.test();
		accountService.test();
		return "^_^";
	}

	@GetMapping("/tx/storage/list")
	public CommonResult listStorage() {
		return new CommonResult(200,"成功", storageService.list());
	}

	@GetMapping("/tx/account/list")
	public CommonResult listAccount() {
		return new CommonResult(200,"成功", accountService.list());
	}

}
