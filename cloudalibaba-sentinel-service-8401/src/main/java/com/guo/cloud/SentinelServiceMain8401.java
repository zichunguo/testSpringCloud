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
public class SentinelServiceMain8401 {
	public static void main(String[] args) {
		SpringApplication.run(SentinelServiceMain8401.class, args);
	}
}
