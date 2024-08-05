package FrameWork.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count = 0;
		int max = 2;
		
		if(count<max)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
