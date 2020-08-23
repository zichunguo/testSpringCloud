package com.guo.cloud.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author guo
 * @date 2020/8/22
 */
@RestController
@Slf4j
public class FlowLimitController {

	@GetMapping("/testA")
	public String testA() {
		// 测试流控规则中的阈值类型为"线程数"，开两个窗口同时访问会直接报错
//		try {
//			TimeUnit.MILLISECONDS.sleep(800);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return "--> testA. O(∩_∩)O";
	}

	@GetMapping("/testB")
	public String testB() {
		log.info(Thread.currentThread().getName() + ". testB...");
		return "--> testB. O(∩_∩)O";
	}

	/**
	 * 测试服务降级策略
	 * @return
	 */
	@GetMapping("/testD")
	public String testD() {
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("testD 测试 RT");

		return "--> testD. O(∩_∩)O";
	}

	@GetMapping("/testE")
	public String testE() {
		log.info("testF 测试异常比例");
		int i = 10 / 0;

		return "--> testE. O(∩_∩)O";
	}

	@GetMapping("/testF")
	public String testF() {
		log.info("testF 测试异常数");
		int i = 10 / 0;

		return "--> testF. O(∩_∩)O";
	}

	@GetMapping("/testHotKey")
//	@SentinelResource(value = "testHotKey") // 如果设置热点规则时，没有配置 blockHandler，将会抛出异常，显示 Error Page
//	@SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
	public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
							 @RequestParam(value = "p2", required = false) String p2) {
		return "--> testHotKey. 测试热点规则";
	}

	/**
	 * 上方法的过滤处理方法
	 * @param p1
	 * @param p2
	 * @param exception
	 * @return
	 */
	public String deal_testHotKey(String p1, String p2, BlockException exception) {
		// Sentinel 系统默认的提示：Blocked by Sentinel（flow limiting）
		return "--> deal_testHotKey. o(╥﹏╥)o";
	}
}
