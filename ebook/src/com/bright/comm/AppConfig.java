package com.bright.comm;
import java.io.FileInputStream;
import java.util.Properties;

public class AppConfig {
  
	public static String getValue(String key){
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream("E:\\work\\ebook\\src\\app.properties"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
