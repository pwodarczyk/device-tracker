package com.tracker.util;


public class ServerUtil {

	private static String imageHostName;

	public static void setImageHostName(String imageHostName) {
		ServerUtil.imageHostName = imageHostName;
	}

	public static String getImageHostName() {
		return imageHostName;
	}
	
	
}
