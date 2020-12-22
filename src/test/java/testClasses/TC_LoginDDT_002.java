package testClasses;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.XLUtils;
import org.junit.Assert;
import pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname,String pwd) throws IOException, InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(uname);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			CaptureScreen(driver, "TC_LoginDDT_002");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	public boolean isAlertPresent() 
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/testData/LoginData.xlsx";

		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int colNum=XLUtils.getCellCount(path, "Sheet1", 1);
		//Store excel data in two dimensional array
		String logindata[][]=new String[rowNum][colNum];

		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
