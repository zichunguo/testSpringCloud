package com.guo.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import com.guo.cloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guo
 * @date 2020/8/23
 */
@RestController
public class RateLimitController {

	@GetMapping("/byResource")
	@SentinelResource(value = "byResource", blockHandler = "blockHandlerException")
	public String byResource() {
		return "byResource. O(∩_∩)O";
	}

	public String blockHandlerException(BlockException exception) {
		return "blockHandlerException. 服务不可用. o(╥﹏╥)o";
	}

	@GetMapping("/rateLimit/byUrl")
	@SentinelResource("byUrl")
	public String byUrl() {
		return "byUrl. O(∩_∩)O";
	}

	/**
	 * 测试自定义限流处理流程，使用外部来统一处理，实现业务与异常处理逻辑分离，降低耦合，避免代码膨胀
	 * @return
	 */
	@GetMapping("/rateLimit/customerBlockHandler")
	@SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
	public String customerBlockHandler() {
		return "customerBlockHandler. O(∩_∩)O";
	}
}
