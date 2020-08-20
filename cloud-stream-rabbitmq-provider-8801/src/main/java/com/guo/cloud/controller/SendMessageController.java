package com.guo.cloud.controller;

import com.guo.cloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/20
 */
@RestController
public class SendMessageController {

	@Resource
	private IMessageProvider messageProvider;

	@GetMapping("/message/send")
	public String sendMessage() {
		return messageProvider.send();
	}
}
