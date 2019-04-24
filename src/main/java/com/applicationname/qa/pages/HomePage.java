package com.applicationname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.applicationname.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory or OR -- Object Repository :
	// driver.findElement(By.xpath("")).click(); : Modified by FindBy

	@FindBy(xpath = "//td[contains(text(),'User: SaiPrasad Chigullapally')]")
	//@CacheLookup  // performance of the script improves. execution will be fast; 
	// instead of locater going to webpage it goes to small memory.i.e: CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactsLink;

	// initialize the constructor to

	public HomePage() {

		PageFactory.initElements(driver, this);
		
	}

	// Actions or Methods or features of individual pages.

	public String verifyHomePageTitle() {

		String title = driver.getTitle();
		return title;

	}
	
	
	public ContactsPage clickonContactsLink() {
		
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName() {
		boolean label=userNameLabel.isDisplayed();
		return label;
	}
	
	public void clickonNewContactLink() {
		Actions action =new Actions(driver); 
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
	}
}
