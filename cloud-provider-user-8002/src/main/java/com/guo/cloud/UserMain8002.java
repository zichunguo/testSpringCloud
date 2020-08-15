package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guo
 * @date 2020/8/14
 */
@SpringBootApplication
@EnableEurekaClient
public class UserMain8002 {
	public static void main(String[] args) {
		SpringApplication.run(UserMain8002.class, args);
	}
}
