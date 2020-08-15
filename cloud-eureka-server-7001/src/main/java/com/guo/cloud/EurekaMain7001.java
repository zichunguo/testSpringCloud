package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author guo
 * @date 2020/8/14
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7001.class, args);
	}
}
