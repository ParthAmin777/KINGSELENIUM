package com.td.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.td.qa.pages.HomePage;
import com.td.qa.pages.LoginPage;
import com.td.qa.utillities.TestUtilities;
import com.td.qa.utillities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver evedriver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("C:\\Selenium_WorkSpace\\TDbankPOMTest\\src\\main\\java\\com\\td\\qa\\config\\config.properties");
			prop.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void OpenBrowserWithWebsite() {
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			 driver= new ChromeDriver();
		}else { 
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			 driver= new ChromeDriver();
		}
		
		evedriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		evedriver.register(eventListener);
		driver = evedriver;
		
		
		
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, LoginPage.class);
		//NotetoMySelf: without initializing the page factory, we cant call on any methods from TestClass
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		driver.get(prop.getProperty("url"));
		HomePage.popup.click();
		driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(TestUtilities.pageloadtimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.implicitwait, TimeUnit.SECONDS);
		
		
	}

}
