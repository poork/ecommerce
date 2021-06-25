package com.ecommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public  ReadConfig()
	{	 
		File src=new File("./Configuration/Config.properties");
		try
		{
			FileInputStream configfile=new FileInputStream(src);
			pro=new Properties();
			pro.load(configfile);
		
		}
		
		catch(Exception e)
		{
			System.out.println("Exception is  " + e.getMessage());
		}
	}
	
	public String getUrl()
	{
		 
		 String url=pro.getProperty("baseURL");
		//System.out.println("geturl1"+pro.getProperty("baseURL"));
		 return url;
	}
	
	public String getUsremail()
	{
		return pro.getProperty("useremail"); 
	}
	
	public String getUsrPwd()
	{
		return pro.getProperty("password"); 
	}
	
	
	public String getCstEmail()
	{
		return pro.getProperty("customeremail"); 
	}
	
	
	public String getdriverpath(String browser)
	{
		String browserpath="";
		if(browser.equals("chrome"))
		{
			browserpath=pro.getProperty("chromepath");
		}
		else if (browser.equals("firefox"))
		{
			browserpath=pro.getProperty("firefoxpath");	
		}
		else if(browser.equals("ie"))
		{
			browserpath=pro.getProperty("iepath");
		}
		return browserpath;
	}
}
