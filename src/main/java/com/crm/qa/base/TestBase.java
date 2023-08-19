package com.crm.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.crm.qa.pages.FacebookPage;
import com.crm.qa.pages.WallethubProfilePage;
import com.crm.qa.testdata.TestData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

public class TestBase {
	
	public static WebDriver driver;
	public static FacebookPage facebookpage;
	public static WallethubProfilePage wallethubpage;

	Dotenv dotenv = Dotenv.load(); // Load values from .env file

	public final String FACEBOOK_EMAIL = dotenv.get("FACEBOOK_EMAIL");
	public final String FACEBOOK_PASSWORD = dotenv.get("FACEBOOK_PASSWORD");

	public final String WALlETHUB_PROFILE_URL = dotenv.get("WALlETHUB_PROFILE_URL");

	public final String WALLETHUB_USERNAME = dotenv.get("WALLETHUB_USERNAME");

	public final String WALLETHUB_PASSWORD = dotenv.get("WALLETHUB_PASSWORD");
	
	public static void initialization(){
		PropertyConfigurator.configure("src/main/resources/log4j2.properties");
		String browserName = TestData.BROWSER;
		
		if(browserName.toLowerCase().equals("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if(browserName.toLowerCase().equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestData.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestData.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	@BeforeSuite
	public void setUpSuite() {
		// Setup code before the suite
		initialization();
		facebookpage = new FacebookPage(driver);
		wallethubpage = new WallethubProfilePage(driver);

	}

	@AfterSuite
	public void tearDownSuite() {
		// Teardown code after the suite
		driver.quit();
	}

	@BeforeTest
	public void setUpBeforeTest() {
		// This method will be executed before all test methods within the <test> tag.
		// Place your setup code here.
	}

	@AfterTest
	public void tearDownAfterTest() {
		// This method will be executed after all test methods within the <test> tag.
		// Place your cleanup code here.
	}

	@BeforeMethod
	public void setUpBeforeMethod() {
		// This method will be executed before each individual test method.
		// Place your setup code here.
	}

	@AfterMethod
	public void tearDownAfterMethod() {
		// This method will be executed after each individual test method.
		// Place your cleanup code here.
		//driver.close();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
