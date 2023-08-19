package com.crm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookPage extends BasePage {


	By inputEmailText = By.id("email");
	By inputPasswordText = By.id("pass");
	By buttonLogin = By.name("login");
	By inputPostText = By.xpath("//*[contains(text(), \"What's on your mind\")]");
	By inputPostText2 = By.xpath("(//div[contains(text(),\"What's on your mind\")]//parent::div/div)[1]");
	By buttonPost = By.xpath("//div[@aria-label=\"Post\"]");

	public FacebookPage(WebDriver driver){
		this.driver = driver;
	}

	public void setEmail(String email){
		sendKey(inputEmailText, email);
	}

	public void setPassword(String password){
		sendKey(inputPasswordText, password);
	}

	public void clickLogin(){
		click(buttonLogin);
	}

	public void post(String postMessage){
		click(inputPostText);
		sendKey(inputPostText2, postMessage);
		click(buttonPost);
	}



	
	
	
	
	
	
	

}
