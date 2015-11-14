package com.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class WebBrowerTest {
	private Selenium s ;
	SeleniumServer seleniumServer;

	@Before
	public void setUp() throws Exception {
		String brower = "*firefox";
		seleniumServer = new SeleniumServer();
		seleniumServer.start();
		s = new DefaultSelenium("localhost", seleniumServer.getPort(), brower,"http://baidu.com");
		s.start();
	}

	@After
	public void tearDown() throws Exception {
		s.stop();
	    seleniumServer.stop();
	}

	@Test
	public void test() throws Exception{
		s.open("/");
		s.windowMaximize();
		s.waitForPageToLoad("20000");
		s.click("//p[@id='u']/a[2]");
		s.waitForPageToLoad("20000");
		s.type("//input[@id='username']", "szyshf");
		Thread.sleep(2000);
		s.type("normModPsp", "420923");
		s.click("mem_pass");
		Thread.sleep(2000);
		s.click("mem_pass");
		s.submit("//form[1]");
		s.waitForPageToLoad("20000");
		s.type("kw", "在这里输入搜索的关键字");
		s.submit("f");
	}
}
