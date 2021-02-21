package ddl.qa.qs.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ddl.qa.qs.base.BasePage;
import ddl.qa.qs.base.BaseTest;
import ddl.qa.qs.pages.HomePage;
import ddl.qa.qs.pages.LoginPage;

public class HomePageTest extends BaseTest{

	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;

//	@BeforeTest
//	public void setUp() {
//		basePage = new BasePage();
//		driver = basePage.init_driver("chrome");
//		loginPage = new LoginPage(driver);
//		driver.get("http://sharantest6701/dist/#/login");
//		homePage = loginPage.doLogin("QuickshipDemo", "admin", "password123");
//
//	}
	
	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("regCode"),prop.getProperty("username"),prop.getProperty("password"));
	}
	
@Test
public void homePageHEaderTest() {
	String header = homePage.getHomePageHeaderValue();
	System.out.println("home page header is : "+header);
	Assert.assertEquals(header, "Quick Ship");
}
	
@Test
public void homePageLinksTest() {

}

	
	
	
	
	
//
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
