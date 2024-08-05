package FrameWork.test_cases;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Abstracts.Abstractmethods;
import FrameWork.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.Products;

import FrameWork.testcomponents.Retry;

public class T1 extends BaseTest{
	
	//WebDriver driver;
	
	//static String email = "ms.vilaspure@gmail.com";
	//static String password = "87622@Mv";
	//static String p1 = "ZARA COAT 3";
	static String name = "IPHONE 13 PRO";
	static String country = "India";
	static String successmessagae = "THANKYOU FOR THE ORDER.";
	
	
	@Test(dataProvider="getdata",groups={"purchase"}, retryAnalyzer=Retry.class)
	
	public void purchase(HashMap<String,String> input) throws InterruptedException, IOException
	{
		t.loginmethod(input.get("email"), input.get("password"));
		
		Products p = t.product();
		p.purchase1(input.get("product1"));
		p.purchase2(input.get("product2"));
		p.addtocard();
		p.verify(input.get("product2"));
		boolean match = p.verify(input.get("product2"));
		Assert.assertTrue(match);
		p.removeoneandcheckeout();
		p.orderdetails(country);
		p.ordersuccess();
		Assert.assertEquals(successmessagae, p.ordersuccess());	
		//p.ordermenu();
		
		
	}

	@Test(dependsOnMethods="purchase",dataProvider="orderverify",groups={"orderverify"})
	public void orderverify(String email,String password) throws IOException, InterruptedException
	{
		System.out.println("Hi");
		//applaunch();
		t.loginmethod(email, password);
		Products p = new Products(driver);
		p.ordermenu();
		Assert.assertTrue(p.orderverify());
	}
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		/*HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "ms.vilaspure@gmail.com");
		map.put("password", "87622@Mv");
		map.put("product1", "ZARA COAT 3");
		map.put("product2", "IPHONE 13 PRO");
		
		HashMap<String,String> map1 =new HashMap<String,String>();
		map1.put("email", "ms.vilaspure@gmail.com");
		map1.put("password", "87622@Mv");
		map1.put("product1", "ZARA COAT 3");
		map1.put("product2", "IPHONE 13 PRO");
		return new Object[] [] {{map},{map1}};*/
		
		List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\madhukar.v\\eclipse-workspace\\New\\Selenium\\src\\test\\java\\FrameWork\\data\\Input.json");
		return new Object[] [] {{data.get(0)},{data.get(1)}};
	}
	
 	@DataProvider
	public Object[][] orderverify()
	{
		return new Object[] [] {{"ms.vilaspure@gmail.com","87622@Mv"}};
	}


}


