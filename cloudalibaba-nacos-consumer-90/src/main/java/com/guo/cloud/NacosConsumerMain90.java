package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guo
 * @date 2020/8/21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerMain90 {
	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerMain90.class, args);
	}
}
