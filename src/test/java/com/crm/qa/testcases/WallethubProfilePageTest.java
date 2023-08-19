package com.crm.qa.testcases;

import com.crm.qa.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import java.lang.reflect.Method;

import static com.crm.qa.util.extentreports.ExtentTestManager.startTest;

public class WallethubProfilePageTest extends TestBase {

	@Test(priority=1)
	public void Test01(Method method){
		startTest(method.getName(), "Add a review");
		driver.get(WALlETHUB_PROFILE_URL);
		String title = driver.getTitle();
		System.out.println("title is: " + title);
		Assert.assertEquals(title, TestData.WALLETHUB_PROFILE_URL_TITLE);
		wallethubpage.reviewAdd();

	}

	@Test(priority=2)
	public void Test02(Method method){
		startTest(method.getName(), "Login Scenario with username and password.");
		wallethubpage.login(WALLETHUB_USERNAME, WALLETHUB_PASSWORD);
	}


}
