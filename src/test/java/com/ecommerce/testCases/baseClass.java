package com.ecommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.ecommerce.utilities.ReadConfig;



public class baseClass {
 
	
	ReadConfig r=new ReadConfig();

	public String url=r.getUrl();
	 
	public String name=r.getUsremail();
	public String pwd=r.getUsrPwd();
	public String cstemail=r.getCstEmail();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		
		logger=Logger.getLogger("ecommerce");
		PropertyConfigurator.configure("log4j.properties");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",r.getdriverpath(browser));
			driver = new ChromeDriver();
		
		}
		else if (browser.equals("firefox"))
		{

			System.setProperty("webdriver.gecko.driver",r.getdriverpath(browser));
			driver = new FirefoxDriver();
		}
		else if (browser.equals("ie"))
		{

			System.setProperty("webdriver.ie.driver",r.getdriverpath(browser));
			driver = new InternetExplorerDriver();
		}
	 

	}
	
    @AfterClass
	public void exit()
	{
		driver.close();
	}
	
	public void setTimout(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		logger.info("capturing screenshot");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		System.out.println("Screenshot taken"+target);
		FileUtils.copyFile(source, target);
	 
		System.out.println("Screenshot taken");
	}
	
	public void capturefullPageScreenshot(WebDriver driver,String tcname)
	{
	  
	       Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS,500,true).withName(tcname).save();
	      
	  }
	
	
	
}
