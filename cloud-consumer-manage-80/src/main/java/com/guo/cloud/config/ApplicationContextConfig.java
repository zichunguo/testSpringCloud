package com.guo.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author guo
 * @date 2020/8/14
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
	@LoadBalanced	// 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡能力（当使用 Eureka 集群请求时，不加该注解会报错，找不到具体的主机）
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
