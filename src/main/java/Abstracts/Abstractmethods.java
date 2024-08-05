package Abstracts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractmethods{
	
	WebDriver driver;
	
	public Abstractmethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	
	public void visibilityOfElementLocated(By tagname)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(tagname));
	}
	
	public void visibilityOfelement(WebElement cart)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(cart));
	}
	
	public void actions(WebElement move)
	{
		Actions a = new Actions(driver);
		a.moveToElement(move).build().perform();
	}
}
