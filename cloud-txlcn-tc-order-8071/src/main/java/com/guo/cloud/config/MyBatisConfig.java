package com.guo.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author guo
 * @date 2020/8/27
 */
@Configuration
@MapperScan("com.guo.cloud.dao")
public class MyBatisConfig {
}
