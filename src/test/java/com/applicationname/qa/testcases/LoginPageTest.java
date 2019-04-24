package com.applicationname.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.applicationname.qa.base.TestBase;
import com.applicationname.qa.pages.HomePage;
import com.applicationname.qa.pages.LoginPage;

// Regarding log4j api :
// what is log?:capturing inf/activities at the time of program execution.
// Types of logs:
//1.info
//2.warn
//3.error
//4.fatal

// How to generate logs? : use Apache log4j API
// How it works? :It's reads log4j configuration from log4j.properties file.
// where to create? : create inside resources folder.



public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	

	public LoginPageTest() {
		super(); // It will call the parent class constructor: For initialization of Properties
					// variables.
	}

	@BeforeMethod
	public void setUP() {
		intialization();
		loginpage = new LoginPage();

	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");

	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag=loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
