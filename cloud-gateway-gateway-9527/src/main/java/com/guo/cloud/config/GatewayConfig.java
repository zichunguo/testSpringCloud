package com.guo.cloud.config;

import com.guo.cloud.filter.MyLogGatewayFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guo
 * @date 2020/8/18
 */
@Configuration
public class GatewayConfig {

	@Bean
	public GlobalFilter customFilter() {
		return new MyLogGatewayFilter();
	}
	/**
	 * 使用编码的方式配置路由规则
	 * @param builder
	 * @return
	 */
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		RouteLocatorBuilder.Builder routes = builder.routes();
		// 配置一个 id 为 route_baidu 的路由规则
		// 当访问地址：http://localhost:9527/guonei 时会自动跳转到地址：https://news.baidu.com/guonei
//		return routes.route("route_baidu", r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
		return routes.route("route_baidu", r -> r.path("/*").uri("https://news.baidu.com/")).build();
	}
}
