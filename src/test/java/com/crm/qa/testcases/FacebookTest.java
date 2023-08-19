package com.crm.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import com.crm.qa.base.TestBase;
import com.crm.qa.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.crm.qa.util.extentreports.ExtentTestManager.startTest;

public class FacebookTest extends TestBase {

	@Test(priority=1, description = "Login to facebook and post hello world.")
	public void Test01(Method method) throws InterruptedException, IOException {
		driver.get(TestData.URL);
		//ExtentReports Description
		startTest(method.getName(), "Login to facebook and post hello world.");
		String title = driver.getTitle();
		System.out.println("title is: " + title);
		Assert.assertEquals(title, TestData.URL_TITLE);
		facebookpage.setEmail(FACEBOOK_EMAIL);
		facebookpage.setPassword(FACEBOOK_PASSWORD);
		facebookpage.clickLogin();
		facebookpage.post("Hello World");
	}

}
