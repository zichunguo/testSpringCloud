package com.guo.cloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author guo
 * @date 2020/8/20
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

	@Resource
	private MessageChannel output;// 消息发送管道

	@Override
	public String send() {
		String uuid = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(uuid).build());
		String result = "send message uuid: " + uuid;
		System.out.println(result);
		return result;
	}
}
