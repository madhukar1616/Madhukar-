package testresources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports extentreport()
	{
		String File = "C:\\Users\\madhukar.v\\eclipse-workspace\\New\\Selenium\\reports";
		ExtentSparkReporter spark = new ExtentSparkReporter(File);
		spark.config().setDocumentTitle("Teting Report");
		spark.config().setDocumentTitle("Testing Result");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		return extent;
	}

}
