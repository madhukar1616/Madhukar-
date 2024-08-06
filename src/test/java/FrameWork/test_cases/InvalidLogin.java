package FrameWork.test_cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import FrameWork.testcomponents.BaseTest;
import junit.framework.Assert;

public class InvalidLogin extends BaseTest{
	
	@SuppressWarnings("deprecation")
	@Test(groups={"error"})
	
	public void invalidlogin()
	{
		
		t.loginmethod("madhu@gmail.com", "87622");
		Assert.assertEquals("Incorrect email or password.", t.invlaidlogin());
		System.out.println("Logged in successfully lets move now");
		
	
	} 
	
	

}
