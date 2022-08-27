package com.td.qa.testdata;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.td.qa.base.TestBase;
import com.td.qa.pages.HomePage;
import com.td.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
		
		LoginPage loginPage;
		HomePage homePage ;
		public HomePageTest() {
		super();
		}
		
		@BeforeMethod
		public void firstwebpage() {
			OpenBrowserWithWebsite();
			homePage = new HomePage();
			
		}
		
		@Test(priority =1)
		public void HomePageTitleTest() {
		String actualtitle = homePage.HomePagetitle();
		Assert.assertEquals(actualtitle, prop.getProperty("HomepageTitle"));
		}
		
		@Test(priority =2)
		public void HeaderList() {
			  homePage.HeaderList();
		}
		
		@Test(priority =3)
		public void DropDownList() throws InterruptedException{
			  homePage.dropdownlist();  
		}
		
		@Test(priority =4)
		public void SelectedLanguagesList() throws InterruptedException{
			  homePage.selectedLanguagelist();
		}
		
		@Test(priority =5)
		public void ServicesMenuList() {
			 homePage.servicemenulist();
		}
		
		@Test(priority =6)
		public void SearchSuggestionList() throws InterruptedException {
			 homePage.searchsuggestionlist();
		}
		
		
		@Test(priority =7)
		public void EnterLoginpage() {
			loginPage = homePage.loginpageEnter();
		}
		
		@AfterMethod
		public void closingbrowser() {
			driver.quit();
		}
	
}
