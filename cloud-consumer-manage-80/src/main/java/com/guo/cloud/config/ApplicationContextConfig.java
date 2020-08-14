package com.guo.cloud.config;

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
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
