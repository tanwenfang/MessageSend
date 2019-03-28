package com.gcb.demo.messageSend.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.minxing.client.app.AppAccount;
import com.minxing.client.app.OcuMessageSendResult;
import com.minxing.client.ocu.ArticleMessage;
import com.minxing.client.organization.User;

@Component
public class SendInfoUtil {

	private Logger logger = LoggerFactory.getLogger(SendInfoUtil.class);
	private static String accToken;
	private static String domain;
	private static String networkId;
	private static String ocuId;
	private static String ocuSecret;
	
	
	private void initConfig() { 
		ResourceBundle res = ResourceBundle.getBundle("application");
		accToken = res.getString("sandbox.acctoken");
		domain = res.getString("sandbox.domain");
		networkId = res.getString("sandbox.networkid");
		ocuId = res.getString("sandbox.ocuid");
		ocuSecret = res.getString("sandbox.ocusecret");
	}

	public void sendOcuMessageToUsers(String[] names, ArticleMessage articleMessage) {
		try {
			initConfig();
			AppAccount account = AppAccount.loginByAccessToken(domain, accToken);
			OcuMessageSendResult ocuMessageSendResult = account.sendOcuMessageToUsers(networkId, names,articleMessage, ocuId, ocuSecret);
			logger.info(">>>>>>>>>>>>>>>" + String.valueOf(ocuMessageSendResult.getMessageId()));
		} catch (Exception e) {
			logger.error("send ocuMessage error", e);
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsersInDepartmentByDataId(String deptCode) {
		initConfig();
		AppAccount account = AppAccount.loginByAccessToken(domain, accToken);
	    List<User> userInfos = new ArrayList<User>();
	    try {
	        userInfos = account.getAllUsersInDepartment(deptCode,false,false);
	    } catch (Exception e) {
	        logger.error("获取部门下的用户发生错误", e);
	    }
	    return userInfos;
	}
}
