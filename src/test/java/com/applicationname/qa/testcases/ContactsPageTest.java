package com.applicationname.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.applicationname.qa.base.TestBase;
import com.applicationname.qa.pages.ContactsPage;
import com.applicationname.qa.pages.HomePage;
import com.applicationname.qa.pages.LoginPage;
import com.applicationname.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testutil;
	String sheetname="contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
		contactspage = new ContactsPage();
		testutil.switchtoFrame();
		contactspage=homepage.clickonContactsLink();
		

	}

	@Test(priority=1)
	public void verifyContactsLabelTest() {
		boolean label = contactspage.verifyContactsLabel();
		Assert.assertTrue(label, "Contacts label is missing on the page");

	}
	
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactspage.selectContactsByName("chigullapally Sreenivasulu");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactspage.selectContactsByName("David Cris");
		contactspage.selectContactsByName("Gubba Padma");
		contactspage.selectContactsByName("Mukta Sharma");
		
	}
	
	@DataProvider
	public Object[][] getTestCRMData() {
		
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
		
	}
	
	@Test(priority=4,dataProvider="getTestCRMData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company) {
		homepage.clickonNewContactLink();
//		contactspage.createNewContact("Mr.", "First", "interviw", "letmecall");
		contactspage.createNewContact(title, firstname,lastname, company);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
