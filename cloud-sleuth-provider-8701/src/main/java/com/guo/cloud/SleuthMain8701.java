package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guo
 * @date 2020/8/20
 */
@SpringBootApplication
@EnableEurekaClient
public class SleuthMain8701 {
	public static void main(String[] args) {
		SpringApplication.run(SleuthMain8701.class, args);
	}
}
