package com.guo.cloud.controller;

import com.guo.cloud.domain.CommonResult;
import com.guo.cloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/23
 */
@RestController
public class StorageController {

	@Resource
	private StorageService storageService;

	@GetMapping("/storage/decrease")
	public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
		storageService.decrease(productId, count);
		return new CommonResult(200, "扣减库存成功");
	}

	@GetMapping("/tx/test")
	public String test() {
		storageService.test();
		return "^_^";
	}
}
