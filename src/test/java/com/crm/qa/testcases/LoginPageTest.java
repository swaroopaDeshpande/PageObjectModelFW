package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	// constructor
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initilization();
		loginpage = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String Title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Free CRM software in the cloud powers sales and customer service");
	}

	@Test(priority=2)
	public void crmLogoImgTest() {
		boolean flag = loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
