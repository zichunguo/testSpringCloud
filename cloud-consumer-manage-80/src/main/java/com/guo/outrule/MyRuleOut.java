package com.guo.outrule;

import com.guo.cloud.rule.MyRoundRobinRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 官方文档警告：这个自定义配置类不能放在 @ComponentScan 所扫描的当前包以及子包下
 * @author guo
 * @date 2020/8/15
 */
@Configuration
public class MyRuleOut {

	@Bean
	public IRule ribbonRule() {
//		return new RoundRobinRule();// 轮询
//		return new RandomRule();// 随机
		return new MyRoundRobinRule();// 自定义规则
	}

}
