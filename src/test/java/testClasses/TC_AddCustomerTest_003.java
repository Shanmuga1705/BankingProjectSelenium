package testClasses;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException  
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickLogin();
		
		Thread.sleep(5000);		
		AddCustomerPage addcust=new AddCustomerPage(driver);		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		addcust.custName("Vignesh");
		addcust.custgender("male");
		addcust.custdob("10","15","1992");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		String email=randomestring()+"@gmail.com";
		
		//String email="jvignesh107@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		logger.info("validation started....");		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			CaptureScreen(driver,"addNewCustomer");
			logger.info("test case failed....");			
			Assert.assertTrue(false);
		}
	}
}
