package com.td.qa.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.td.qa.base.TestBase;
import com.td.qa.config.ExcelDataFile;

public class HomePage extends TestBase{
	
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	ExcelDataFile df= new ExcelDataFile();
	
	
	@CacheLookup
	@FindBy(id = "ensCall")
	public static WebElement popup;
	
	@FindBys(@FindBy(xpath ="//div[@class='td-segments']/ul/li/a"))
	public static List<WebElement> topper; 
	
	@FindBy(xpath = "//a[@id='td-desktop-nav-dropdown-link-2']")
	public static WebElement droplink1;
	
	@FindBy(xpath = "//a[@id='td-desktop-nav-dropdown-link-3']")
	public static WebElement droplink2;
	
	@FindBy(xpath = "//a[@id='td-desktop-nav-dropdown-link-4']")
	public static WebElement droplink3;
	
	@FindBys(@FindBy(xpath ="//ul[@aria-labelledby='td-desktop-nav-dropdown-link-2']/li/a"))
	public static List<WebElement> dplist1;
	
	@FindBys(@FindBy(xpath ="//ul[@aria-labelledby='td-desktop-nav-dropdown-link-3']/li/a"))
	public static List<WebElement> dplist2;
	
	@FindBys(@FindBy(xpath ="//ul[@aria-labelledby='td-desktop-nav-dropdown-link-4']/li/a"))
	public static List<WebElement> dplist3;
	
	@FindBy(xpath = "//a[@id='td-desktop-nav-dropdown-link-1']")
	public static WebElement LanguageButton;
	
	@FindBys(@FindBy(xpath ="//ul[@aria-labelledby='td-desktop-nav-dropdown-link-1']/li/a"))
	public static List<WebElement> LanguageList;
	
	@FindBys(@FindBy(xpath ="//div[@class='td-row services services-col9']//a"))
	public static List<WebElement> serviceList;
	
	@FindBy(id = "question")
	public static WebElement search;
	
	@FindBys(@FindBy(xpath ="//div[@class='suggestion-dropdown ng-scope']//span"))
	public static List<WebElement> searchList;
	
	@FindBy(xpath = "//button[contains(@onclick,'//easyweb.td.com/')]")
	public static WebElement LoginEasyWeb;

	public  HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String HomePagetitle() {
		return driver.getTitle();
	}
	
	public void HeaderList() {
		  topper.size();
		  for(WebElement a: topper) {
		  System.out.println(a.getText());
		  }
	}
	
	public void dropdownlist() throws InterruptedException {
		
		System.out.println("--------------------FIRST LIST STARTED---------------------");
		
		Actions Builder1 = new Actions(driver);
		Builder1.moveToElement(droplink1).build().perform();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfAllElements(dplist1));
		
		dplist1.size();
		for(WebElement a: dplist1) {
			System.out.println(a.getText()); 
		}
		
		System.out.println("--------------------SECOND LIST STARTED---------------------");
		
		Actions Builder2 = new Actions(driver);
		Builder2.moveToElement(droplink2).build().perform();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfAllElements(dplist2));
		
		dplist2.size();
		for(WebElement b : dplist2) {
			System.out.println(b.getText());
		}
		
		System.out.println("--------------THIRD TEST STARTED-----------------------");
		
		
		Actions Builder3 = new Actions(driver);
		Builder3.moveToElement(droplink3).build().perform();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfAllElements(dplist3));

		dplist3.size();
		for(WebElement c: dplist3) {
			System.out.println(c.getText());
		}
	}
	
	public void selectedLanguagelist() throws InterruptedException {
		LanguageButton.click();
		
		Actions Builder4 = new Actions(driver);
		Builder4.moveToElement(LanguageButton).build().perform();
		//wait.until(ExpectedConditions.visibilityOfAllElements(LanguageList));
		Thread.sleep(2000);
		LanguageList.size();
		for(WebElement a: LanguageList) {
			System.out.println(a.getText());
		}
		
	}
	
	public void servicemenulist() {
		serviceList.size();
		for(WebElement b: serviceList) {
		System.out.println(b.getText());  
	 }		
	}
	public void searchsuggestionlist() throws InterruptedException {
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("arguments[0].click();", search);
		  search.sendKeys(df.searchkeywords);
		  Thread.sleep(2000);
		  //wait.until(ExpectedConditions.visibilityOfAllElements(searchList));
		  
		  searchList.size();
		  for(WebElement c: searchList) {
		  System.out.println(c.getText());
		  }
	}
	
	
	public LoginPage loginpageEnter() {
		LoginEasyWeb.click();
		return new LoginPage();
	}
	
	
	
}
