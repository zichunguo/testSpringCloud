package com.guo.cloud.controller;

import com.guo.cloud.domain.CommonResult;
import com.guo.cloud.domain.Order;
import com.guo.cloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/23
 */
@RestController
public class OrderController {

	@Resource
	private OrderService orderService;

	// 测试：http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
	@GetMapping("/order/create")
	public CommonResult create(Order order) {
		orderService.create(order);
		return new CommonResult(200, "订单创建成功");
	}

	@GetMapping("/tx/test")
	public String test() {
		orderService.test();
		return "^_^";
	}

}
