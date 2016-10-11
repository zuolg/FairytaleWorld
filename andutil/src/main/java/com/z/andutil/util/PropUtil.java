package com.z.andutil.util;

import java.util.Properties;

import android.content.Context;

/**
 * 
 * @ClassName PropUtil
 * @Description TODO
 * @author zuolangguo
 * @date 2015年12月18日 下午4:11:39
 */
public class PropUtil {
	
	/**
	 * 获取配置文件的值
	 * @Title: getV 
	 * @Description: TODO
	 * @param @param mContext
	 * @param @param key
	 * @param @return    设定文件 
	 * @return String    返回类型
	 */
	public static String getV(Context mContext, String key) {
	  
		return getV(mContext, key, "");
	}
	
	/**
	 * 获取配置文件的值
	 * @Title: getV 
	 * @Description: TODO
	 * @param @param mContext
	 * @param @param key
	 * @param @return    设定文件 
	 * @return String    返回类型
	 */
	public static String getV(Context mContext, String key,String defaultValue) {
		String value = null;
		Properties properties = new Properties();
		try {
			properties.load(mContext.getAssets().open("config.properties"));
			value = properties.getProperty(key, defaultValue);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
		return value;
	} 

}
