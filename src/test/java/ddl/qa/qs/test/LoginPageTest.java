package ddl.qa.qs.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ddl.qa.qs.base.BasePage;
import ddl.qa.qs.base.BaseTest;
import ddl.qa.qs.pages.LoginPage;
import ddl.qa.qs.util.Constants;

@Test
public class LoginPageTest extends BaseTest {
	WebDriver driver;
	
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		//driver = basePage.init_driver("chrome");
		loginPage = new LoginPage(driver);
		driver.get("http://sharantest6701/dist/#/login");

	}

	public void verifyLoginPageTitleTest() {
		String titleLoginPage = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is: " + titleLoginPage);
		//Assert.assertEquals(titleLoginPage, "Quick Ship", "Title of the Login Page is incorrect");
		Assert.assertEquals(titleLoginPage, Constants.LOGIN_PAGE_TITLE, Constants.LOGIN_PAGE_TITLE_ERROR_MESSG);
	}

	public void verifyRememberMeTest() {
		Assert.assertTrue(loginPage.isRememberMeExist(), Constants.REMEMBER_ME_ERROR_MESSG);
	}

	public void loginTest1() {
		//loginPage.doLogin("QuickshipDemo", "admin", "password123");
		loginPage.doLogin(prop.getProperty("regCode"),prop.getProperty("username"),prop.getProperty("password"));
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
