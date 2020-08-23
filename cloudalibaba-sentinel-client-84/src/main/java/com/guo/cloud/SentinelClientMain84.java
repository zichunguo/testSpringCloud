package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guo
 * @date 2020/8/22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelClientMain84 {
	public static void main(String[] args) {
		SpringApplication.run(SentinelClientMain84.class, args);
	}
}
