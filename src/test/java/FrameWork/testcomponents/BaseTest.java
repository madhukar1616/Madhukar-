package FrameWork.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import FrameWork.test_cases.Ordercheck;
import FrameWork.test_cases.T1;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.Orderverify;
import pageObjects.Products;

public class BaseTest {

	public static WebDriver driver;

	public static LandingPage t;
	public static Ordercheck ord;

	public static WebDriver browsers() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\madhukar.v\\eclipse-workspace\\New\\Selenium\\src\\main\\java\\testresources\\globalData.properties");
		prop.load(file);
		
		String browsername = System.getProperty("browser")!= null? System.getProperty("browser"):prop.getProperty("browser");

		if (browsername.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browsername.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage applaunch() throws IOException {
		System.out.println("Running ####");
		driver = browsers();
		LandingPage t = new LandingPage(driver);
		t.url();
		this.t = t;
		return t;

	}

	@AfterMethod(alwaysRun = true)
//	@AfterMethod
	public void close() {
		System.out.println("Closing!!");
		driver.close();
	}

	public void orders() throws InterruptedException, IOException {

		Orderverify ord = new Orderverify(driver);
		ord.order();

	}
	

	public List<HashMap<String, String>> getJsonDataToMap(String file) throws IOException

	{

	//read json to string

	String jsonContent = FileUtils.readFileToString(new File(file),

	StandardCharsets.UTF_8);

	//String to HashMap- Jackson Datbind

	ObjectMapper mapper = new ObjectMapper();

	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		
	});
	return data;
	}
	
	public static String getscreenshot(String Testcasename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\madhukar.v\\OneDrive - Atyati Technologies Pvt Ltd\\Desktop\\New folder\\"+Testcasename+".png");
		FileUtils.copyDirectory(src, file);
		String path = "C:\\Users\\madhukar.v\\OneDrive - Atyati Technologies Pvt Ltd\\Desktop\\New folder\\"+Testcasename+".png";
		return path;
		
	}
	
}
