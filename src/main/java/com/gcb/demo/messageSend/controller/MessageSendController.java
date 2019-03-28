package com.gcb.demo.messageSend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcb.demo.messageSend.po.AvailableResult;
import com.gcb.demo.messageSend.po.MessageSend;
import com.gcb.demo.messageSend.service.MessageSendService;

@RestController
@RequestMapping("/send/message/")
public class MessageSendController {

	@Autowired
	private MessageSendService messageSendService;

	// 1，批量保存日程的接口
	@RequestMapping("sendMessage")
	public AvailableResult sendMessage(@RequestBody MessageSend messageSend) {
		return messageSendService.sendMessage(messageSend);
	}
}
