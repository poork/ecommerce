package com.ecommerce.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Searchcustomer {
	
	WebDriver ldriver;
	public Searchcustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="SearchEmail") WebElement inputemail;
	@FindBy(name="SearchFirstName") WebElement inputfs;
	@FindBy(name="SearchLastName") WebElement inputls;

	@FindBy(id="SearchCompany") WebElement inputcompanyname;
	@FindBy(id="SearchMonthOfBirth") WebElement dropdownmonth;
	@FindBy(id="SearchDayOfBirth") WebElement dropdownday;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[2]/div/div") WebElement selectrole;
	@FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]") WebElement xmark; 
	
	@FindBy(id="search-customers") WebElement btnsearch;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody") WebElement resulttable;
	
	//*[@id="customers-grid"]/tbody/tr/td[2]
	
 
	
	public void sendemail(String email)
	{
		 inputemail.sendKeys(email);
	}
	public void sendfs(String fs)
	{
		 inputfs.sendKeys(fs);
	}
	public void sendls(String ls)
	{
		 inputls.sendKeys(ls);
	}
	public void sendcompanyname(String cn)
	{
		 inputcompanyname.sendKeys(cn);
	}
	
	public void selectrole()
	{
		selectrole.click();
		xmark.click();
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]")).click();
		 
	}
	
	
	public void selectdob(String mon,String day)
	{
		Select smon=new Select(dropdownmonth);
		Select sday=new Select(dropdownday);
		smon.selectByVisibleText(mon);
		sday.selectByVisibleText(day);

	}
	
	public void clicksearchbtn()
	{
		btnsearch.click();
	}
	
	
	public String checkrecords()
	{
		 
		 
		String result="";
		int row=ldriver.findElements(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr")).size();
		System.out.println("row"+row);
		if(row==1)
		{
			WebElement tr=ldriver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr"));
			result=tr.getText();
		}	
		else
		{
			 result = ldriver.findElement(By.tagName("body")).getText();
			 
			}
		
		return result;	
		}
		
		
	} 
 
