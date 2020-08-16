package com.guo.cloud.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 官方文档警告：这个自定义配置类不能放在 @ComponentScan 所扫描的当前包以及子包下
 * 为了保持包的规则性，这里该类是放在了 @ComponentScan 所扫描子包下，为了不让 @ComponentScan 扫描，使用注解排除功能
 * @author guo
 * @date 2020/8/15
 */
// 放在 @ComponentScan 所扫描子包下时不能加 @Configuration注解
//@Configuration
@ExcludeFromComponentScan
public class MyRule {

	@Bean
	public IRule ribbonRule() {
//		return new RoundRobinRule();// 轮询
//		return new RandomRule();// 随机
		return new MyRoundRobinRule();// 自定义规则
	}

}
