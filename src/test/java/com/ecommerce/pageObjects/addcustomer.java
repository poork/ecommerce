package com.ecommerce.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
 

public class addcustomer {
	WebDriver ldriver;
	public addcustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	By btnadd= By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By  treecustomer=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By  lnkcustomer = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	By  inputemail = By.id("Email");
	By  inputpwd = By.name("Password");
	By  fs= By.xpath("//*[@id=\"FirstName\"]");
	By  ls=By.xpath("//*[@id=\"LastName\"]");
	By radiomale=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[5]/div[2]/div/div[1]/label");
	By radiofemale=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[5]/div[2]/div/div[2]/label");
	By dpdate=By.xpath("//*[@id=\"DateOfBirth\"]");
	By inputcompanyname=By.xpath("//*[@id=\"Company\"]");
	By chkboxtax=By.xpath("//*[@id=\"IsTaxExempt\"]");
	By dropdownnewsletter=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div");
	 
	By xmark=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]");
	
	By guest=By.xpath("//li[contains(text(),'Guests')]");
	By ddvendor=By.xpath("//*[@id=\"VendorId\"]");
	By chkboxactive=By.xpath("//*[@id=\"Active\"]");
	By txtareacmt=By.xpath("//*[@id=\"AdminComment\"]");
	By btnsave=By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
	
	By btnplus=By.xpath("//*[@id=\"customer-info\"]/div[1]/div[2]/button");
	
	
	
	public void clickbtnadd()
	{
		ldriver.findElement(btnadd).click();
		
	}
	

	public void clickbtnplus()
	{
		
		try
		{
			WebElement expand=ldriver.findElement(btnplus);
		 
			if(expand.isDisplayed())
			{	
				System.out.println("element found");
				expand.click();
			}
		}
		catch (Exception e)
		{
			System.out.println("element not found");
		}
	}
	
	
	public void clicktreecustomer()
	{
		ldriver.findElement(treecustomer).click();
		
	}
	public void clicklnkcustomer()
	{
		ldriver.findElement(lnkcustomer).click();
		
	}
	
	public void sendemail(String email)
	{
		ldriver.findElement(inputemail).sendKeys(email);
	}
	
	public void sendpwd(String pwd)
	{
		ldriver.findElement(inputpwd).sendKeys(pwd);
	}
	

	public void sendfs(String fsname)
	{
		ldriver.findElement(fs).sendKeys(fsname);
	}
 

	public void sendls(String lsname)
	{
		ldriver.findElement(ls).sendKeys(lsname);
	}
 
	public void clikemale( )
	{
		ldriver.findElement(radiomale).click();
	}
	
	public void clikefemale( )
	{
		ldriver.findElement(radiofemale).click();
	}
 
	public void senddate(String date)
	{
		ldriver.findElement(dpdate).sendKeys(date);
	}
 
	public void sendcn(String cn)
	{
		ldriver.findElement(inputcompanyname).sendKeys(cn);
	}
 
	public void clicktaxchkbox()
	{
		ldriver.findElement(chkboxtax).click();
	}
 
	/*public void selectnewsletter(String nl)
	{
		Select s=new Select(ldriver.findElement(dropdownnewsletter));
		s.selectByVisibleText(nl);
		 
	}*/
	
	public void selectnewsletter(String nl)
	{
		//*[@id="customer-info"]/div[2]/div[10]/div[2]/div/div[1]/div/div
		ldriver.findElement(dropdownnewsletter).click();
		//ldriver.findElement(xmark).click();
		
		WebElement lsitem;
		switch(nl)														 
		{	 															 
			case "Your store name": lsitem=ldriver.findElement(By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[1]"));
									 break;
			default:
				lsitem=ldriver.findElement(guest);
						
		}
		lsitem.click();
	}
	
	public void selectguest(String role)
	{
		//*[@id="customer-info"]/div[2]/div[10]/div[2]/div/div[1]/div/div
		 
		ldriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")).click();
		ldriver.findElement(xmark).click();
		WebElement lsitem;
		switch(role)
		{
			case "Guests":  System.out.println("gest"); lsitem=ldriver.findElement(guest); System.out.println("gest"); break;
			default:
				lsitem=ldriver.findElement(guest);
						
		}
		//lsitem.click();
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", lsitem);
		System.out.println("guest selected");
	}
	
	public void selectvendor(String vendor)
	{
		Select drp=new Select(ldriver.findElement(ddvendor));
		drp.selectByVisibleText(vendor);
	}
	
	public void clickradio(String gender)
	{
		if(gender.equals("male"))
		{
		 ldriver.findElement(radiomale).click();
		}
	}
	
	
	public void clickactivechkbox()
	{
		ldriver.findElement(chkboxactive).click();
	}
	
	

	
	public void commnet()
	{
		ldriver.findElement(txtareacmt).sendKeys("test ");;
	}
	public void clicksavebtn()
	{
		ldriver.findElement(btnsave).click();
	}
} 
