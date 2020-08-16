package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guo
 * @date 2020/8/16
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ManageHystrix80 {
	public static void main(String[] args) {
		SpringApplication.run(ManageHystrix80.class, args);
	}
}
