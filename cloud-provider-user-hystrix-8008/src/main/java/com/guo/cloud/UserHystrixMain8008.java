package com.guo.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author guo
 * @date 2020/8/16
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class UserHystrixMain8008 {
	public static void main(String[] args) {
		SpringApplication.run(UserHystrixMain8008.class, args);
	}

	/**
	 * 此配置是为了服务监控而配置，与服务容错本身无关，SpringCloud 升级后的坑
	 * ServletRegistrationBean 因为 SpringBoot 的默认路径不是 /actuator/hystrix.stream
	 * 只要在自己的项目里配置上下面的 Servlet 就可以了
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}
