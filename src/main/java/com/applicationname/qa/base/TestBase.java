package com.applicationname.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.applicationname.qa.utilities.TestUtil;
import com.applicationname.qa.utilities.WebEventListener;
// This is the base class which contains common code
public class TestBase {

	public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventlistener;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"E:\\myselenium\\Projectname\\src\\main\\java\\com\\applicationname\\qa\\configuration\\config.properties ");

			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Intialization of browser and open url 
	
	public static void intialization() {
		
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Selenium softwares\\chromedriver.exe");
		     driver=new ChromeDriver();
		}
		else if(browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SAI\\Desktop\\mindq practice\\webdriverbrowsers\\geckodriver.exe ");
			driver=new FirefoxDriver();
		
		}
		e_driver=new EventFiringWebDriver(driver);
	    eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
//		Dimension d=new Dimension(250,220);
//		driver.manage().window().setSize(d); : To set the size of the window.
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
}
