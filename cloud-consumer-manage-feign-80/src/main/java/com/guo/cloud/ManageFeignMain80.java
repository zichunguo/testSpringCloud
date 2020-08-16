package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guo
 * @date 2020/8/16
 */
@SpringBootApplication
@EnableFeignClients
public class ManageFeignMain80 {
	public static void main(String[] args) {
		SpringApplication.run(ManageFeignMain80.class, args);
	}
}
