package com.gcb.demo.messageSend.po;

import java.io.Serializable;
import java.util.List;

public class MessageSend implements Serializable{

	private static final long serialVersionUID = -6554619309373981447L;

	private List<MessageSendVo> names;
	
	private String message;

	public List<MessageSendVo> getNames() {
		return names;
	}

	public void setNames(List<MessageSendVo> names) {
		this.names = names;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageSend [names=" + names + ", message=" + message + "]";
	}
}
