package com.guo.cloud.service;

import com.guo.cloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {
	@GetMapping("/account/decrease")
	CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
