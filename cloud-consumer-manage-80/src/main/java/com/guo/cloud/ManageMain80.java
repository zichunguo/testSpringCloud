package com.guo.cloud;

import com.guo.cloud.rule.ExcludeFromComponentScan;
import com.guo.cloud.rule.MyRule;
import com.guo.outrule.MyRuleOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author guo
 * @date 2020/8/14
 */
@SpringBootApplication
@EnableEurekaClient
// 自定义负载均衡的配置，方式一：MyRuleOut 自定义配置类不能放在 @ComponentScan 所扫描的当前包以及子包下
//@RibbonClient(name = "CLOUD-USER-SERVICE", configuration = MyRuleOut.class)
// 自定义负载均衡的配置，方式而：MyRule 自定义配置类放在 @ComponentScan 子包下，使用注解排除文件扫描。
//@RibbonClient(name = "CLOUD-USER-SERVICE", configuration = MyRule.class)
//@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class ManageMain80 {
	public static void main(String[] args) {
		SpringApplication.run(ManageMain80.class, args);
	}
}
