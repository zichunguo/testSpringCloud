package com.guo.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author guo
 * @date 2020/8/14
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
	@LoadBalanced	// 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡能力（当使用 Eureka 集群请求时，不加该注解会报错，找不到具体的主机）
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/*
	// 官方文档明确给出警告，自定义配置类不能放在 @ComponentScan 所扫描的当前包以及子包下，否则我们自定义的这个配置类就会被所有的 Ribbon 客户端所共享，也就是说我们达不到特殊化定制的目的。
	// 在此处修改会使所有的 Ribbon 客户端共享，即当本微服务调用多个服务提供者时，所有的调用（即 Ribbon 客户端）都会使用此处的设置。
	// 如果想要对某个微服务调用使用特定的负载算法，自定义配置类不能放在 @ComponentScan 所扫描的当前包以及子包下，参见 com.guo.myrule.MyRule
	@Bean
	public IRule ribbonRule() {
		// 用此处的算法，替代默认的轮询选择算法
//		return new RoundRobinRule();// 默认算法，轮询算法
		return new RandomRule();// 随机算法
//		return new RetryRule();// 重试，先按照 RoundRobinRule（轮询）的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用服务
//		return new AvailabilityFilteringRule();// 会先过滤由于多次访问故障而处于断路由跳闸状态的服务，还有并发的连接数超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
//		return new WeightedResponseTimeRule();// 根据平均响应的时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高，刚启动时如果统计信息不足则使用 RoundRobinRule 策略，等统计信息足够会切换到 WeightedResponseTimeRule
//		return new BestAvailableRule();// 会先过滤由于多次访问故障而处于断路由跳闸状态的服务，然后选中一个并发量最小的服务
//		return new ZoneAvoidanceRule();// 默认规则，符合判断 server 所在区域的性能和 server 的可用性选择服务器
	}
	*/

}
