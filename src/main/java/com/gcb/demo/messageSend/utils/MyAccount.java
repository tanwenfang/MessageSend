package com.gcb.demo.messageSend.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minxing.client.model.MxException;
import com.minxing.client.ocu.Article;
import com.minxing.client.ocu.ArticleMessage;

public class MyAccount {

	private Logger logger = LoggerFactory.getLogger(MyAccount.class);
	
	public void sendOcuMessage(List<String> nameList, String title,String description) {
		 
	    try {
	    	SendInfoUtil sendInfoUtil = new SendInfoUtil();
	        ArticleMessage articleMessage = new ArticleMessage();
	        logger.info("the description is ====" + description);
	        articleMessage.addArticle(new Article(title, description, null,null,null));
	        String[] names = new String[nameList.size()];
	        for (int i = 0; i < nameList.size(); i++) {
	            names[i] = nameList.get(i);
	        }
	        sendInfoUtil.sendOcuMessageToUsers(names, articleMessage);
	    }  catch (MxException e) {
	        logger.error("send ocuMessage error", e);
	        e.printStackTrace();
	    } catch (Exception e) {
	    	logger.error("send ocuMessage error", e);
	        e.printStackTrace();
		}
	}
}
