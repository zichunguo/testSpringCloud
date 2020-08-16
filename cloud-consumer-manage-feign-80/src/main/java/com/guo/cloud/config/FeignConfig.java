package com.guo.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试 OpenFeign 的日志答应功能，修改配置 Logger.Level 的 bean
 * @author guo
 * @date 2020/8/16
 */
@Configuration
public class FeignConfig {
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
