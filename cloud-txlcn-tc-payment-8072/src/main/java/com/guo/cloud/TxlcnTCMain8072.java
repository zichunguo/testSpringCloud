package com.guo.cloud;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guo
 * @date 2020/8/27
 */
@SpringBootApplication(exclude={DruidDataSourceAutoConfigure.class})
@EnableEurekaClient
@EnableDistributedTransaction
public class TxlcnTCMain8072 {
	public static void main(String[] args) {
		SpringApplication.run(TxlcnTCMain8072.class, args);
	}
}
