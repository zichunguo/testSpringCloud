package com.guo.cloud.controller;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 sleuth + zipkin 分布式请求链路跟踪
 * 测试需要先启动 zipkin
 * zipkin jar 下载地址：https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/
 * 		或在 zipkin 的 github 中下载最新版本：https://github.com/openzipkin/zipkin，找到 "latest released server" 点击下载
 * 		或使用 docker 启动
 * 运行：java -jar zipkin-server-2.12.9-exec.jar
 * 访问：http://localhost:9411/zipkin
 * @author guo
 * @date 2020/8/20
 */
@RestController
public class SleuthProviderController {

	@GetMapping("/sleuth/zikpin")
	public String testZipkin() {
		return "(*^▽^*)";
	}
}
