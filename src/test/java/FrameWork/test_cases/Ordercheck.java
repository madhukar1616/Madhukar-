package FrameWork.test_cases;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Abstracts.Abstractmethods;
import FrameWork.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.Orderverify;
import pageObjects.Products;

public class Ordercheck extends BaseTest{
	//WebDriver driver;
	
		
		static String p1 = "ZARA COAT 3";
		static String name = "IPHONE 13 PRO";
		static String country = "India";
		static String successmessagae = "THANKYOU FOR THE ORDER.";

	static String email = "ms.vilaspure@gmail.com";
	static String password = "87622@Mv";
	@Test
	public static void order() throws InterruptedException, IOException
	{
		
		T1 bs = new T1();
		bs.purchase(null);
		bs.applaunch();
		t.loginmethod("ms.vilaspure@gmail.com", "87622@Mv");
		Products p = new Products(driver);
		p.ordermenu();
		Assert.assertTrue(p.orderverify());
		
	}
	
	
	
	public static void orderverify() throws IOException
	{
		
		ord.orderverify();
	}

	

}


