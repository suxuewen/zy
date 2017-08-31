package com.zhiyou100.zy.web.utils;

import org.springframework.util.DigestUtils;

public class Md5utils {

	public static String getMd5(String str){
		return DigestUtils.md5DigestAsHex(str.getBytes());
		
	}
	
	
	
	
}
