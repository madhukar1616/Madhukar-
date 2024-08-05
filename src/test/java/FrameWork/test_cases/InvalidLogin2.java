package FrameWork.test_cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import FrameWork.testcomponents.BaseTest;
import junit.framework.Assert;

public class InvalidLogin2 extends BaseTest{
	
	@SuppressWarnings("deprecation")
	@Test(groups={"error"})
	
	public void invalidlogin()
	{
		String File = "C:\\Users\\madhukar.v\\eclipse-workspace\\New\\Selenium\\reports\\rpt.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(File);
		spark.config().setReportName("Test result");
		spark.config().setDocumentTitle("Testing reports");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Madhukar");
		extent.createTest("TOne");
		extent.flush();
		
		
		t.loginmethod("madhu@gmail.com", "87622");
		Assert.assertEquals("Incorrect email password.", t.invlaidlogin());
		
	
	} 
	
	

}
