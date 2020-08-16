package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guo
 * @date 2020/8/16
 */
@SpringBootApplication
@EnableEurekaClient
public class TestMain8101 {
	public static void main(String[] args) {
		SpringApplication.run(TestMain8101.class, args);
	}
}
