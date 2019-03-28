package com.gcb.demo.messageSend.utils;

public class StringUtil {

	public static boolean nullAndEmpty(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取模糊查询用的字符串，过滤 % _
	 * @param parameter
	 * @return
	 */
	public static String getParameterLike(String parameter){
		String parameterLike = parameter;
		if(!StringUtil.nullAndEmpty(parameter)){
			parameterLike = parameterLike.replace("%", "/%").trim();
			parameterLike = parameterLike.replace("_", "/_");
			parameterLike = "%"+parameterLike+"%";
		}
		return parameterLike;
	}
}
