package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() 
	{
		File src=new File("./Configuration/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() 
	{
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword() 
	{
		String password=prop.getProperty("password");
		return password;
	}
	public String getChromePath() 
	{
		String chromePath=prop.getProperty("chromePath");
		return chromePath;
	}
	public String getIEPath() 
	{
		String IEPath=prop.getProperty("IEPath");
		return IEPath;
	}
	public String getFirefoxPath() 
	{
		String FirefoxPath=prop.getProperty("FirefoxPath");
		return FirefoxPath;
	}
}
