package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstracts.Abstractmethods;

public class LandingPage extends Orderverify {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css=".toast-container")
	WebElement loginerror;
	
	
	public void url()
	{
		driver.get("https:rahulshettyacademy.com/client/"); 
		
	
	}
	public void loginmethod(String mail,String pwd)
	{
		email.sendKeys(mail);	
		password.sendKeys(pwd);
		login.click();
		
	} 
	
	public String invlaidlogin()
	{
		loginerror.getText();
		return loginerror.getText();
	}
	public Products product()
	{
		Products p = new Products(driver);
		return p;
	}

}
