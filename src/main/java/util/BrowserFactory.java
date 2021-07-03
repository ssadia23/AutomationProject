package util;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BrowserFactory {

	static WebDriver driver;
	static String browser = "chrome";
	
	
	public static WebDriver inIt() {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/sadia/Desktop/Selenium/AutomationProject/Drivers/chromedriver");
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/sadia/Desktop/Selenium/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		return driver;
		
	}
	
	public static void tearDown() {
		
		driver.close();
		driver.quit();
	}
	
	
		
	
		
	
}
