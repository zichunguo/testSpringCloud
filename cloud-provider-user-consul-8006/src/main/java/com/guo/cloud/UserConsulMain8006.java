package com.guo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guo
 * @date 2020/8/15
 */
@SpringBootApplication
@EnableDiscoveryClient	// 该注解用于向使用 consul 或者 zookeeper 作为注册中心时注册服务
public class UserConsulMain8006 {
	public static void main(String[] args) {
		SpringApplication.run(UserConsulMain8006.class, args);
	}
}
