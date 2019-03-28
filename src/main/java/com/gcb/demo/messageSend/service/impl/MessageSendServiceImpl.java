package com.gcb.demo.messageSend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.gcb.demo.messageSend.po.AvailableResult;
import com.gcb.demo.messageSend.po.MessageSend;
import com.gcb.demo.messageSend.po.MessageSendVo;
import com.gcb.demo.messageSend.service.MessageSendService;
import com.gcb.demo.messageSend.utils.MyAccount;
import com.gcb.demo.messageSend.utils.StringUtil;

@Service
public class MessageSendServiceImpl implements MessageSendService {

	Logger logger = LoggerFactory.getLogger(MessageSendServiceImpl.class);

	@Override
	public AvailableResult sendMessage(MessageSend messageSend) {
		try {
			logger.info(">>>>>>>>>>开始推送消息>>>>>>>>>>");
			
			if (messageSend == null) {
				AvailableResult.errorMsg(">>>>>>>>>>请求参数为空");
			}
			if (messageSend.getNames() == null || messageSend.getNames().isEmpty()) {
				AvailableResult.errorMsg(">>>>>>>>>>推送人员的登录名为空");
			}
			if (StringUtil.nullAndEmpty(messageSend.getMessage())) {
				AvailableResult.errorMsg(">>>>>>>>>>待推送的消息为空");
			}
			
			List<MessageSendVo> mList = messageSend.getNames();
			List<String> nameList = new ArrayList<String>();
			for (MessageSendVo mSendVo : mList) {
				nameList.add(mSendVo.getName());
			}
			logger.info(">>>>>>>>>>推送人员名单：" + JSONArray.toJSONString(nameList));
			logger.info(">>>>>>>>>>待推送消息：" + messageSend.getMessage());
			
			MyAccount myAccount = new MyAccount();
			String description = "验证码：" + messageSend.getMessage();
			myAccount.sendOcuMessage(nameList, "您有一条新的推送消息", description);
			logger.info(">>>>>>>>>>结束推送消息>>>>>>>>>>");
			return AvailableResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(">>>>>>>>>>推送消息异常，原因为：" + e.getMessage());
			return AvailableResult.errorException(e.getMessage());
		}
	}
}