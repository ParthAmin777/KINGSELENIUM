package com.td.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.td.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@CacheLookup
	@FindBy(id = "ensCall")
	public static WebElement popup;
	
	@FindBy(xpath = "//button[contains(@onclick,'//easyweb.td.com/')]")
	public static WebElement LoginEasyWeb;
	
	@FindBy(id = "username")
	public static WebElement UserName;
	
	@FindBy(id = "uapPassword")
	public static WebElement Password;
	
	@FindBy(xpath = "//button[@class='btn btn-block td-button-secondary']")
	public static WebElement LoginButton;
	
	@FindBy(id = "error")
	public static WebElement GlobalError;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter your Username or Access Card number.')]")
	public static WebElement EmptyUserError;
	
	@FindBy(xpath = "//span[text()='Please enter your password']")
	public static WebElement EmptyPasswordError;
	
	public  LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String Pagetitle() {
		return driver.getTitle();
	}
	
	public void LoginWithWrongEmailAndPassword(String a, String b) {
		UserName.sendKeys(a);
		Password.sendKeys(b);
		LoginButton.click();	
	}
	
	public String readGlobalError() {
		String Actual = GlobalError.getText();
		System.out.println(Actual);
		return Actual;
	}
	
	public String readEmptyEmailError() {
		String Actual = EmptyUserError.getText();
		System.out.println(Actual);
		return Actual;	
	}
	
	public String readEmptyPasswordError() {
		String Actual = EmptyPasswordError.getText();
		System.out.println(Actual);
		return Actual;	
	}
}
