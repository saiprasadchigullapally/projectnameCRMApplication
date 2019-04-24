package com.applicationname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.applicationname.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory --- OR (Object Repository) driver.findElement(By.name()).click()
	// -- instead of this we use : @findBy

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signupBtn;

	@FindBy(xpath = "(//img[contains(@class,'img-responsive')])[1]")
	WebElement crmLogo;

	// To initialize all pagefactory Objects or WebElements we use constructor

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// actions or methods or features of the page

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginBtn.click();
		
		return new HomePage();
		
	}
}
