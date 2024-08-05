package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Abstracts.Abstractmethods;

import pageObjects.LandingPage;
import pageObjects.Products;

public class Orderverify{
	WebDriver driver;
	
	public Orderverify(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement> orderitem;

	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderbutton;
	
	
	
	public void order()
	{
		orderbutton.click();
	}
	
	
	public boolean orderverify()
	{
		boolean match = orderitem.stream().anyMatch(s->s.getText().contains("IPHONE 13 PRO"));
		return match;
	}


	


}


