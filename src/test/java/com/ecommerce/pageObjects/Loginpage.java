package com.ecommerce.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class Loginpage {

	WebDriver ldriver;
	public Loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="Email")
	//@CacheLookup
	WebElement txtName;
	
	@FindBy(id="Password")
	//@CacheLookup
	WebElement txtPwd;
	
	@FindBy(xpath="//*[@id=\"RememberMe\"]")
	//@CacheLookup
	WebElement chkRemember;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	//@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	WebElement lnklogout;
	
	public void setTimout(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	public void sendname(String name)
	{
		txtName.clear();
		txtName.sendKeys(name);
	}
	
	public void sendpassword(String pwd)
	{
		txtPwd.clear();
		txtPwd.sendKeys(pwd);
	}
	
	public void clickchkbox()
	{
		chkRemember.click();
	}
	
	public void clicklogin()
	{
		btnLogin.click();
	}
	
	public void clicklogout()
	{
		lnklogout.click();
	}
	
	
	
	
	
}
