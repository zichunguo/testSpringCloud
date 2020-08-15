package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guo
 * @date 2020/8/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserConsulMain8006 {
	public static void main(String[] args) {
		SpringApplication.run(UserConsulMain8006.class, args);
	}
}
