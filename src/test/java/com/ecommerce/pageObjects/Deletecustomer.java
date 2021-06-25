package com.ecommerce.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deletecustomer {
	
	WebDriver ldriver;
	
	public Deletecustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr/td[7]/a") WebElement btnedit;
	@FindBy(xpath="//*[@id=\"customer-delete\"]") WebElement btndelete;
	
	public void clickbtnedit()
	{
		btnedit.click();
	}
	
	public void clickbtndelete()
	{
		btndelete.click();
	}

	public void confirmdelete()
	{
		//ldriver.switchTo().alert();
		ldriver.findElement(By.cssSelector("#customermodel-Delete-delete-confirmation > div > div > form > div > div.modal-footer > button")).click();
		 
	}
}
