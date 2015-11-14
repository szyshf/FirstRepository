package com.test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class QQZoneTest {

	private Selenium selenium ;
	private SeleniumServer server ;
	private String brower = "*firefox";
	private String url = "http://qzone.qq.com/";
	
	@Before
	public void setUp() throws Exception{
		server = new SeleniumServer();
		selenium = new DefaultSelenium("localhost",server.getPort(),brower,url);
		server.start();
		selenium.start();
	}
	
	@Test
	public void testOpenZone(){
	   selenium.setTimeout("30000");
	   selenium.open("/");
	   selenium.windowMaximize();
	   selenium.type("u", "190671076");
	   selenium.type("p", "625lhh810,");
	   selenium.click("//input[@id='subbtn']");
	   selenium.waitForPageToLoad("90000");
	}
	
	@After
	public void tearDown(){
		selenium.stop();
		server.stop();
	}
	
	public static void main(String[] args) {
       String string = "显示环境变量和JVM的缺省属性";
       System.out.println(chinaToUnicode(string));
       System.out.println(unicodeToChinese(chinaToUnicode(string)));
       DateFormat d = new SimpleDateFormat();
       d.format(new Date());
	}
	/**
	 * 中文转unicode
	 * @param str
	 * @return
	 */
	public static String  chinaToUnicode(String str)
    {
        String result = "";
        for (int i = 0; i < str.length(); i++)
        {
            int chr1 = (char) str.charAt(i);
            result  += "\\u" + Integer.toHexString(chr1);           
        }
        return result;
    }
	
	/**
     * unicode转中文
     * @param  str
     * @return 中文
     */
     public static String unicodeToChinese(String str)
     {         
         
    	 String[] seqChars = str.split("\\\\u");  
    	 String ret = "";
		 for(String character : seqChars) {  
		          if(null != character && !"".equals(character)){   
		             ret += String.valueOf((char) Integer.parseInt(character, 16));
		          }
		 }
         return ret;
     }
}
