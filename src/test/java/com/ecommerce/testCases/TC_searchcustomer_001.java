package com.ecommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.Loginpage;
import com.ecommerce.pageObjects.Searchcustomer;
import com.ecommerce.pageObjects.addcustomer;

public class TC_searchcustomer_001 extends baseClass{
	
	@Test(enabled=true)
	public void searchcustomer() throws IOException, InterruptedException
	{
		logger.info("Opening URL");
		driver.get(url);
		setTimout(driver);
		Loginpage lp=new Loginpage(driver);
		lp.sendname(name);
		lp.sendpassword(pwd);
		lp.clicklogin();
		logger.info("Logged in  ");
		addcustomer a=new addcustomer(driver);
		a.clicktreecustomer();
		a.clicklnkcustomer();
		logger.info("searching starts");
		Searchcustomer s=new Searchcustomer(driver);
		s.sendemail(cstemail);
		s.selectrole();
		
		s.clicksearchbtn();
		logger.info("clicked search button");
		Thread.sleep(5000);
		String validate=s.checkrecords();
		//System.out.println("result"+validate);
		if(validate.contains("Nagarajan saravanan"))
		{
			logger.info("record is present");
			Assert.assertTrue(true);
		}
		else if(s.checkrecords().contains("No data available in table"))
		{
			logger.info("no record is present");
			capturefullPageScreenshot(driver,"searchcustomer");
			Assert.assertTrue(false);
			
		}
		else if(s.checkrecords().contains("Duplicate Records"))
		{
			logger.info("one or more records are present");
			//captureScreen(driver,"searchcustomer");
			capturefullPageScreenshot(driver,"searchcustomer");
			Assert.assertTrue(false);
		}
		
	}

}
