package com.wd.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
	
	public static void main(String[] args) {
		
	}
	
	public static String getUniqueId() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddhhmmss");
		return sd.format(new Date());
	}
}
