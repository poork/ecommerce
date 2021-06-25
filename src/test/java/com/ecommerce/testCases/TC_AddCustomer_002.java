package com.ecommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.*;


public class TC_AddCustomer_002 extends baseClass {
	
	 
	
	@Test(enabled=true)
	public void addCustemer() throws IOException, InterruptedException
	{	 
		
		driver.get(url);
	
		logger.info("opening URL");
		setTimout(driver);
		Loginpage lp=new Loginpage(driver);
		lp.sendname(name);
		lp.sendpassword(pwd);
		lp.clicklogin();
		logger.info("Logged IN ");
		addcustomer ac=new addcustomer(driver);
		logger.info("object created");
		ac.clicktreecustomer();
		ac.clicklnkcustomer();
		ac.clickbtnadd();
		Thread.sleep(5000);
		//ac.clickbtnplus();
		ac.sendemail("naga@gmail.com");
		ac.sendpwd("rajan");
		ac.sendfs("Nagarajan");
		ac.sendls("saravanan");
		ac.clikemale();
		ac.senddate("11/30/1994");
		ac.sendcn("TCS");
		ac.clicktaxchkbox();
		ac.selectnewsletter("Your store name");
	 
		ac.selectguest("Guests");
		ac.selectvendor("Vendor 1");
		ac.clickactivechkbox();
		ac.commnet();
		ac.clicksavebtn();
		logger.info("clicked save ");
		String resultstring="";
		//WebElement result=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]"));

		String result = driver.findElement(By.tagName("body")).getText();
		 
		
		/*WebElement elementisnotunique=driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[2]/ul/li"));
		if(elementisnotunique.isDisplayed())
		{
			System.out.println("text no unique"+result.getText());
			resultstring=result.getText(); 
			Assert.assertTrue(false);
		}
		 */
		if(result.contains("The new customer has been added successfully."))
		{
			logger.info("User is added");
			Assert.assertTrue(true);
		}
		else 
		{
			logger.info("issue taking screenshot  ");
			//captureScreen(driver,"AddCustomer");
			capturefullPageScreenshot(driver,"AddCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
}
