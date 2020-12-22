package testClasses;

import org.testng.annotations.Test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException 
	{
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}else {
			CaptureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");

		}
	}

}
