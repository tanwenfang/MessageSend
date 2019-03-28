package com.gcb.demo.messageSend.po;

import java.io.Serializable;

public class MessageSendVo implements Serializable{

	private static final long serialVersionUID = 8128689984169127432L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MessageSendVo [name=" + name + "]";
	}
}
