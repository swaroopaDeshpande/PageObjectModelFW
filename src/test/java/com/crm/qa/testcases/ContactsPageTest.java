package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;

	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initilization();
		testUtil = new TestUtil();
		contactspage = new ContactsPage();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactspage = homepage.clickOnContactsLinks();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactspage.verifyContactsLabel(), "Contact label is missing on Page");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactspage.selectContactsByName("AA AAA");
		// contactspage.selectContactsByName("abc xyz");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] crmData = TestUtil.getDataFromSheet(sheetName);
		return crmData;
	}

	@Test(priority = 3,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company) {
		homepage.clickOnNewContactLink();
		//contactspage.createNewContact("Mr.", "Bugs", "Test", "Amazon");
		contactspage.createNewContact(title, firstname, lastname, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
