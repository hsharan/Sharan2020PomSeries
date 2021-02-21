package ddl.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ddl.qa.qs.base.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;

	By header = By.cssSelector("h1.ep-title-header");
	By linkText = By.xpath("//h4");

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	// Page actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getHomePageHeaderValue() {
		if (driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;
	}

	public boolean getHomePageLinksValue() {

		if (driver.findElements(linkText).size() > 0) {
			return true;
		}
		return false;
	}

}
