package com.applicationname.qa.utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.applicationname.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	/**********************************
	 * Purpose of the webdrivereventlistener
	 ******************************************/

	// interfaceM-1
	public void beforeNavigateTo(String url, WebDriver arg1) {
		System.out.println("Before navigating to:'" + url + "'");

	}

	// interfaceM-2
	public void afterNavigateTo(String url, WebDriver arg1) {
		System.out.println("Navigated to: '" + url + "'");

	}

	// interfaceM-3
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {

		System.out.println("Before change value of the element:" + element.toString() + "");

	}

	// interfaceM-4
	public void afterChangeValueOf(WebElement element, WebDriver driver) {

		System.out.println("After change value of the element:" + element.toString());

	}

	// interfaceM-7
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on" + element.toString());

	}

	// interfaceM-8
	public void afterClickOn(WebElement element, WebDriver driver) {

		System.out.println("Clicked on" + element.toString());
	}

	// interfaceM-9
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");

	}

	// interfaceM-10
	public void afterNavigateBack(WebDriver arg0) {

		System.out.println("Navigated back to previous page");
	}

	// interfaceM-11
	public void beforeNavigateForward(WebDriver arg0) {

		System.out.println(" Navigated forward to next page");
	}

	// interfaceM-12
	public void afterNavigateForward(WebDriver arg0) {

		System.out.println("Navigated forward to next page");
	}

	// interfaceM-13
	public void onException(Throwable error, WebDriver driver) {
		try {
			TestUtil.takeScreenshotAtEndofTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Exception occured:" + error);
	}

	// interfaceM-14
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element By:" + by.toString());

	}

	// interfaceM-15
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element by:" + by.toString());

	}

	// interfaceM-16
	public void beforeScript(String arg0, WebDriver arg1) {

	}

	// interfaceM-17
	public void afterScript(String arg0, WebDriver arg1) {

	}

	// interfaceM-18
	public void beforeAlertAccept(WebDriver arg0) {

	}

	// interfaceM-19
	public void afterAlertAccept(WebDriver arg0) {

	}

	// interfaceM-20
	public void afterAlertDismiss(WebDriver arg0) {

	}

	// interfaceM-21
	public void beforeNavigateRefresh(WebDriver arg0) {

	}

	// interfaceM-22
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {

	}

	// interfaceM-23
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {

	}

	// interfaceM-24
	public void afterNavigateRefresh(WebDriver arg0) {

	}

	// interfaceM-25
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {

	}

	// interfaceM-26
	public void beforeAlertDismiss(WebDriver arg0) {

	}

	// interfaceM-27
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {

	}

	// interfaceM-28
	public void beforeGetText(WebElement arg0, WebDriver arg1) {

	}

	// interfaceM-29
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

}
