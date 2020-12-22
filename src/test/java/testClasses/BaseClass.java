package testClasses;

import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig=new ReadConfig();
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver",readConfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void CaptureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	protected String randomestring() {
        String Emailid = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * Emailid.length());
            sb.append(Emailid.charAt(index));
        }
        String EmailID = sb.toString();
        return EmailID;
    }
	 /*
	 * public static String randomeNum() { String generatedString2 =
	 * RandomStringUtils.randomNumeric(4); return (generatedString2); }
	 */
	
}
