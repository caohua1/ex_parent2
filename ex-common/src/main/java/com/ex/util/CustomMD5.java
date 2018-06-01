package com.ex.util;

import java.util.Random;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
* @ClassName: CustomMD5 
* @Description: 生成MD5
* @author sanmu
* @date 2017年6月21日 上午8:39:04 
*
 */
public class CustomMD5 {

	/**
	* @Title: passwordAndSalt
	* @Description: 密码放在前面的自定义散列次数的MD5加密
	* @param password 密码
	* @param salt     盐值
	* @return String    返回类型
	 */
	public static String passwordAndSalt(String password,String salt){
		return md5(password,salt,1024);
	}
	/**
	* @Title: md5
	* @Description: md5的加密，私有方法
	* @param str1 	密码
	* @param str2 	盐
	* @param hashIterations  散列次数
	* @return String    返回类型
	 */
	private static String md5(String str1,String str2,int hashIterations){
		SimpleHash simpleHash = new SimpleHash("md5",str1, str2, hashIterations);
		return simpleHash.toString();
	}

}
