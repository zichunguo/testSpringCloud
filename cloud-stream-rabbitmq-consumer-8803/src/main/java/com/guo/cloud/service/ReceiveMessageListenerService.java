package com.guo.cloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author guo
 * @date 2020/8/20
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerService {
	@Value("${server.port}")
	private String serverPort;

	@StreamListener(Sink.INPUT)
	public void input(Message<String> message) {
		System.out.println("serverPort: " + serverPort + ". 消费者 " + serverPort + ". 接收到消息：" + message.getPayload());
	}
}
