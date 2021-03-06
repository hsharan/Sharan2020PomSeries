package ddl.qa.qs.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ddl.qa.qs.pages.HomePage;
import ddl.qa.qs.pages.LoginPage;

public class BaseTest {

	public HomePage homePage;	
	public BasePage basePage;
	public LoginPage loginPage;

	public Properties prop;
	public WebDriver driver;
	

	//@Parameters({ "browser" })
	
	@BeforeTest
	public void setUp(String browserName) {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");

		if (browserName != null) {
			browser = browserName;
		}
		driver = basePage.init_driver(browser);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
