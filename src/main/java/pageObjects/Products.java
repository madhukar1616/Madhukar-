package pageObjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Abstracts.Abstractmethods;


public class Products {
	


	WebDriver driver;
	Abstractmethods a = new Abstractmethods(driver);

	public Products(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h5[@style='text-transform: uppercase;']")
	List<WebElement> products1;
	
	@FindBy(xpath="//h5[@style='text-transform: uppercase;']")
	List<WebElement> products2;
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cart ;
	
	@FindBy(xpath="//button[@class='btn btn-danger']/i[1]")
	WebElement dlt;
	
	@FindBy(xpath="//ul[@style='list-style-type: none;']/li[3]/button")
	WebElement checkout;
	
	
	@FindBy(xpath="//p[@class='itemNumber']/following-sibling::h3")
	List<WebElement> carts;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countrydropdown;
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button[2]/span")
	List<WebElement> selectedcountry;
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']")
	List<WebElement> country;
	
	@FindBy(css=".action__submit i")
	WebElement purchase;
	
	@FindBy(css="h1[class='hero-primary']")
	WebElement success;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']/i")
	WebElement orderbutton;
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement> orderitem;
	
	By First = By.xpath("//h5[@style='text-transform: uppercase;']/b/parent::h5/parent::div/button[2]");	
	By confrimationmessage = By.xpath("//div[text()=' Product Added To Cart ']");
	By visiblewait = By.xpath("//div[text()=' Product Added To Cart ']");
	By cselect = By.tagName("i");
	
		
	
	@FindBy(xpath="//div[text()=' Product Added To Cart ']")
	WebElement Addedmessage;
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	public WebElement FirstProduct(String prd1)
	{
		WebElement abc = products1.stream().filter(products1->products1.findElement(By.tagName("b")).getText().
				contains(prd1)).findFirst().orElse(null);
		System.out.println(abc.getText());
		return abc;
	}
	
	public void purchase1(String pr1)
	{
		WebElement abc = FirstProduct(pr1);
		abc.findElement(First).click();	
		System.out.println(Addedmessage.getText());
		//a.visibilityOfElementLocated(confrimationmessage);
		
	}
	
	public void purchase2(String sp)
	{
		 
		WebElement prd2 = products2.stream().filter(products3->products3.findElement(By.tagName("b")).getText().equals
				(sp)).findFirst().orElse(null);
		System.out.println(prd2.getText());
		prd2.findElement(By.xpath("following-sibling::button[2]")).click();
		//a.visibilityOfElementLocated(visiblewait);

	}
	public void addtocard() throws InterruptedException
	{
		//a.visibilityOfelement(cart);
		Thread.sleep(3000);
		cart.click();
	}
	public boolean verify(String name)
	{
		
		String av = carts.get(1).getText();
		System.out.println(av);
		boolean match = carts.stream().anyMatch(crts->crts.getText().equalsIgnoreCase(name));
		return match;
	}
	
	
	
	
	public void  removeoneandcheckeout() throws InterruptedException
	{
		dlt.click();
		Thread.sleep(2000);
		checkout.click();
		Thread.sleep(2000);
		
	}
	
	public void orderdetails(String countri) throws InterruptedException
	{
		Actions a= new Actions(driver);
		a.sendKeys(countrydropdown, countri).build().perform();
		//Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfAllElements(country));
		WebElement slt = country.stream().filter(s->s.getText().contains("India")).findFirst().orElse(null);
		Thread.sleep(2000);
		slt.findElement(cselect).click();
		Thread.sleep(2000);
		//purchase.click();
		a.moveToElement(purchase).click().build().perform();
		
		
	}
	
	public String ordersuccess()
	{
		 System.out.println(success.getText());
		 return success.getText();
		 
	}
	
	public void ordermenu() throws InterruptedException
	{
		Thread.sleep(3000);
		
		Actions a = new Actions(driver);
		a.moveToElement(orderbutton).click().build().perform();
		//orderbutton.click();
		
	} 
	
	public boolean orderverify()
	{
		boolean match = orderitem.stream().anyMatch(s->s.getText().contains("IPHONE 13 PRO"));
		return match;
	}
	
	
}
