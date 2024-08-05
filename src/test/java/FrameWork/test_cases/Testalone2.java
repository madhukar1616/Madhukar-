package FrameWork.test_cases;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Testalone2  {
	
	


	public static void main(String[] args) throws InterruptedException {
		 //TODO Auto-generated method stub

		String name = "IPHONE 13 PRO";


		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https:rahulshettyacademy.com/client/");
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("userEmail")).sendKeys("ms.vilaspure@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("87622@Mv");
		driver.findElement(By.id("login")).click();
		
		
		//Thread.sleep(5000);

		//iphone selection
		
		
		List<WebElement> lt =driver.findElements(By.xpath("//h5[@style='text-transform: uppercase;']"));

		WebElement abc =lt.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(name)).findFirst().orElse(null);

		abc.findElement(By.xpath("following-sibling::button[2]")).click();
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement abc1 = driver.findElement(By.xpath("//div[text()=' Product Added To Cart ']"));
		
		
		
		String nt = "ADIDAS ORIGINAL";
		
		
		
		//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		wt.until(ExpectedConditions.visibilityOf(abc1));
		System.out.println(abc1.getText());
		Thread.sleep(8);

		//ADIDAS ORIGINAL
		
		
		List<WebElement> secondprdlist =driver.findElements(By.xpath("//h5[@style='text-transform: uppercase;']"));
		
		
		List<String> sc= secondprdlist.stream().map(s->s.getText()).collect(Collectors.toList());
		sc.stream().forEach(s->System.out.println("products+"+s));


		WebElement snd = secondprdlist.stream().filter(S->S.findElement(By.tagName("b")).getText().equals(nt)).findFirst().orElse(null);
		snd.findElement((By.xpath("following-sibling::button[2]"))).click();
		
		
		WebElement abc2 = driver.findElement(By.xpath("//div[text()=' Product Added To Cart ']"));
		
		
		wt.until(ExpectedConditions.invisibilityOf(abc2));

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		//verifying selected products
		
		
		
		List<WebElement> crt = driver.findElements(By.xpath("//p[@class='itemNumber']/following-sibling::h3"));

		boolean vr1 = crt.stream().anyMatch(s->s.getText().equalsIgnoreCase(name));
		boolean vr2 = crt.stream().anyMatch(s->s.getText().equalsIgnoreCase(nt)); 
		
		
		Assert.assertTrue(vr1);
		Assert.assertTrue(vr2);
		Thread.sleep(3000);
		
		//delete one product and check out
		driver.findElement(By.xpath("//div[@class='infoWrap']/div[3]/button[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		//Payment
		
		//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
		Thread.sleep(2000);
		List<WebElement> country = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button[2]/span"));
		Thread.sleep(2000);
		WebElement slt = country.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
		Thread.sleep(4000);
		slt.findElement(By.tagName("i")).click();
		
		driver.findElement(By.xpath("//div[@class='field small'][2]/input")).sendKeys("45412");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector(".title")).getText());
		
		Assert.assertEquals(nt, driver.findElement(By.cssSelector(".title")).getText());
		
		driver.quit();
		
		
		
		
		
		
		
		
		 //by using old
		/*

		for(int i=1; i<lt.size(); i++)
		{
			String nm = lt.get(i).getText();
			if("IPHONE 13 PRO".contains(nm))
			{
				driver.findElements(By.xpath("button[@class='btn w-10 rounded']")).get(i).click();
			}
		}

		 */

	}

}
