package com.guo.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author guo
 * @date 2020/8/18
 */
//@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

	/**
	 * 存在着一个问题，每次请求都会执行两次
	 * @param exchange
	 * @param chain
	 * @return
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("****** MyLogGatewayFilter. start time: " + new Date());
//		String uname = exchange.getRequest().getQueryParams().getFirst("uname");
//		log.info(uname);
//		if (uname == null) {
//			log.info("****** 用户名不能为 null。o(╥﹏╥)o");
//			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//			return exchange.getResponse().setComplete();
//		}
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
