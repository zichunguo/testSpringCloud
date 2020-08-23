package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guo
 * @date 2020/8/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosUserProviderMain9003 {
	public static void main(String[] args) {
		SpringApplication.run(NacosUserProviderMain9003.class, args);
	}
}
