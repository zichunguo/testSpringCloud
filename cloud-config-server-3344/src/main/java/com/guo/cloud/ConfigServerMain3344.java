package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author guo
 * @date 2020/8/19
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerMain3344 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerMain3344.class, args);
	}
}
