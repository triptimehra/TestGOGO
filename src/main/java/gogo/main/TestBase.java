package gogo.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import gogo.util.Util;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	//Declaring global variable to be used in class
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{   //To fetch value from property file. We innitiate property file
		try
		{
			prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/Users/Tripti/workspace/TestAssignment/src/main/java/gogo/properties/config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void innitialize()
	{   //To decide which browser need to test
		String browsername = prop.getProperty("browser");
		if(browsername .equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			FirefoxOptions fo = new FirefoxOptions();
			fo.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		}
		else if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//Configuration before test start
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}


}
