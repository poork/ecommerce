package com.ecommerce.testCases;
import java.io.IOException;

import org.testng.annotations.*;
import org.testng.Assert;

import com.ecommerce.pageObjects.Loginpage;



public class TC_Logintest_001 extends baseClass {
	
	@Test(enabled=true)
	void Logintest() throws IOException 
	{
	 
		driver.get(url);
		logger.info("test case start ");
		Loginpage lp=new Loginpage(driver);
		lp.setTimout(driver);
		lp.sendname(name);
		lp.sendpassword(pwd);
		lp.clicklogin();
		logger.info("clicked login ");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			logger.info("title check ");
			lp.clicklogout();
			Assert.assertTrue(true);
		
		}
		else
		{
			//captureScreen(driver,"Logintest");
			capturefullPageScreenshot(driver,"Logintest");
			Assert.assertTrue(false);
			//takeScreenshot( );

			
		}
		logger.info("test case end ");
	 
	}
}
