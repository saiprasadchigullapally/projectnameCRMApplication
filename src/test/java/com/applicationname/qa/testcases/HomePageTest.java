package com.applicationname.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.applicationname.qa.base.TestBase;
import com.applicationname.qa.pages.ContactsPage;
import com.applicationname.qa.pages.HomePage;
import com.applicationname.qa.pages.LoginPage;
import com.applicationname.qa.utilities.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() throws InterruptedException {

		intialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		contactspage = new ContactsPage();

	}

	// Testcases should be independent with each other.
	// Before each test case launch the browser and login.
	// @Test --execute the test case
	// After execute the each test case close the browser.

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testutil.switchtoFrame();
		boolean flag = homepage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyContactsLink() {
		testutil.switchtoFrame();
		contactspage = homepage.clickonContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
