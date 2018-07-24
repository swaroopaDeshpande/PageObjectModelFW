package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// OR/Page Factory definition

	@FindBy(xpath = "//font[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement TasksLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	// initializing page objects

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLinks() {

		ContactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLinks() {
		DealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLinks() {
		TasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		newContactLink.click();
	}

}
