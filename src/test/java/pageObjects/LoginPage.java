package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		this.ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="uid")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="btnLogin")
	WebElement Loginbtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	public void setUsername(String uname) {
		Username.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	public void clickLogin() {
		Loginbtn.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
