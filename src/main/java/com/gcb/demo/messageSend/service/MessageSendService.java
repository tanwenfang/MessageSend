package com.gcb.demo.messageSend.service;

import com.gcb.demo.messageSend.po.AvailableResult;
import com.gcb.demo.messageSend.po.MessageSend;

public interface MessageSendService {

	AvailableResult sendMessage(MessageSend messageSend);
}
