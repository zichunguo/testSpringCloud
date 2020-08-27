package com.guo.cloud;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guo
 * @date 2020/8/27
 */
@SpringBootApplication
@EnableTransactionManagerServer
public class TxlcnTMMain7970 {
	public static void main(String[] args) {
		SpringApplication.run(TxlcnTMMain7970.class, args);
	}
}
