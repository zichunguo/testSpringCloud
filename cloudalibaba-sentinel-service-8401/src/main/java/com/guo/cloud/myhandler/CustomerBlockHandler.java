package com.guo.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

/**
 * @author guo
 * @date 2020/8/23
 */
public class CustomerBlockHandler {
	public static String handlerException(BlockException exception) {
		return "客户自定义处理，global handlerException. o(╥﹏╥)o";
	}

	public static String handlerException2(BlockException exception) {
		return "客户自定义处理，global handlerException2. o(╥﹏╥)o";
	}
}
