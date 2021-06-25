package com.ecommerce.testCases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.ecommerce.pageObjects.*;
public class TC_Deletecustomer_004 extends baseClass{
	
	@Test(enabled=true)
	public void deleteCustomer() throws IOException, InterruptedException
	{
		logger.info("opening url");
		driver.get(url);
		
		setTimout(driver);
		logger.info("maximizing window");
		Loginpage lp=new Loginpage(driver);
		lp.sendname(name);
		lp.sendpassword(pwd);
		lp.clicklogin();
		logger.info("Login successful");
		addcustomer a=new addcustomer(driver);
		a.clicktreecustomer();
		a.clicklnkcustomer();
		Searchcustomer s=new Searchcustomer(driver);
		s.sendemail(cstemail);
		logger.info("entered email");
		s.selectrole();
		s.clicksearchbtn();
		logger.info("searching....");
		Thread.sleep(5000);
		 
		if(s.checkrecords().contains("Nagarajan"))
		{	
			logger.info("search is finished");
			Deletecustomer d=new Deletecustomer(driver);
			d.clickbtnedit();
			d.clickbtndelete();
			Thread.sleep(5000);
			logger.info("deleting user");
			d.confirmdelete();
			
			String result = driver.findElement(By.tagName("body")).getText();
			//System.out.println("result"+result);
			if(result.contains("deleted"))
			{
				logger.info("user is removed");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("some issue taking screenshot");
				//captureScreen(driver,"Deletecustomer");
				capturefullPageScreenshot(driver,"Deletecustomer");
				Assert.assertTrue(false);
			}
		}
		else
		{	
			logger.info("expected string not present ");
			//captureScreen(driver,"Deletecustomer");
			capturefullPageScreenshot(driver,"Deletecustomer");
			Assert.assertTrue(false);
		}
	}

}
