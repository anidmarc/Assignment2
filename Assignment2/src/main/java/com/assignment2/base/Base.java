package com.assignment2.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assignment2.util.WaitTime;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	
	public Base() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\JAVA Practice\\Assignment2\\src\\main\\java\\com\\assignment2\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void intialization() {
		String browerName = prop.getProperty("browser");
		if (browerName.contentEquals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	
		} 
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(WaitTime.pageloadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WaitTime.implicitime, TimeUnit.SECONDS);	
	}
	
}
