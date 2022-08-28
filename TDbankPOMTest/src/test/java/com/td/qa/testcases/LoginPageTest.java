package com.td.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.td.qa.base.TestBase;
import com.td.qa.config.ExcelDataFile;
import com.td.qa.pages.HomePage;
import com.td.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage LoginPage;
	HomePage homepage ;
	ExcelDataFile df= new ExcelDataFile();
	public LoginPageTest() {
	super();
	}
	
	@BeforeMethod
	public void openbrowserandwebpage() {
		OpenBrowserWithWebsite();
		homepage = new HomePage();
		LoginPage = homepage.loginpageEnter();
			//LoginPage.LoginEasyWeb.click();
	}
	
	@Test(priority =1)
	public void loginpagetitletest() {
		String title =LoginPage.Pagetitle();
		Assert.assertEquals(title, prop.getProperty("LoginPageTitle"));
	}
	
	
	@Test(priority =2)
	public void LoginWrongEmailandPassword() {
		LoginPage.LoginWithWrongEmailAndPassword(df.wrongEmail, df.wrongPassword);
		Assert.assertEquals(df.globalerror,LoginPage.readGlobalError());
	}
	
	@Test(priority =3)
	public void LoginWithEmptyEmail() {
		LoginPage.LoginWithWrongEmailAndPassword("", df.wrongPassword);
		Assert.assertEquals(df.mptEmailerror, LoginPage.readEmptyEmailError());
	}
	
	@Test(priority =4)
	public void LoginWithEmptyPassword() {
		LoginPage.LoginWithWrongEmailAndPassword(df.wrongEmail, "");
		  Assert.assertEquals(df.mptPassworderror, LoginPage.readEmptyPasswordError());
	  }
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
	

}