package ddl.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ddl.qa.qs.base.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;

	// Page Locators : By Locators
	By regCode = By.xpath("//*[@id='regCode']/div/div/input");
	By userName = By.xpath("//*[@id='username']/div/div/input");
	By passW = By.xpath("//*[@id='password']/div/div/input");
	By submitBtn = By.xpath("//div[contains(text(), 'Login')]");
	By remMe = By.xpath("//*[@id=\"chkLocalStorage\"]/div/div/span");

	// 2 Create a constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// Page action / page method

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isRememberMeExist() {
		return driver.findElement(remMe).isDisplayed();
	}

	public HomePage doLogin(String rc, String un, String pw) {
		System.out.println("Login with reg Code is :" + rc + " ;username : " + un + " ;Password :" + pw);
		driver.findElement(regCode).sendKeys(rc);
		driver.findElement(userName).sendKeys(un);
		driver.findElement(passW).sendKeys(pw);
		driver.findElement(submitBtn).click();
		return new HomePage(driver);
		

	}
}
