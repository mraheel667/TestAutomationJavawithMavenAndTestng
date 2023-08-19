package com.crm.qa.pages;

import com.crm.qa.util.helper.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WallethubProfilePage extends BasePage {

    public WallethubProfilePage(WebDriver driver){
        this.driver = driver;
    }

    By reviewsTab = By.xpath("//span[contains(text(), \"Reviews\") and @class=\"nav-txt\"]");
    By fourStartRating = By.xpath("//*[@aria-label=\"4 star rating\" and @role=\"radio\"]");
    By fourStartRatingFilled = By.xpath("//*[@aria-label=\"4 star rating\" and @role=\"radio\" and @aria-checked=\"true\"]");
    By dropdownPolicy = By.xpath("//*[@role=\"button\" and @role=\"button\" and contains(text(), \"Select...\")]");
    By healthInsuranceOption = By.xpath("//li[@role=\"option\" and contains(text(), \"Health Insurance\")]");
    By writeAReviewText = By.xpath("//textarea[@class=\"textarea wrev-user-input validate\"]");
    By submitButton = By.xpath("//div[@role=\"button\" and contains(text(), \"Submit\")]");
    By loginTab = By.xpath("//a[@role=\"tab\" and contains(text(), \"Login\")]");
    By emailText = By.name("em");
    By passText = By.name("pw1");

    By loginButton = By.xpath("(//*[contains(text(), \"Login\")])[2]");
    public void reviewAdd(){
        click(reviewsTab);
        hover(fourStartRating);
        isLocatorDisplayed(fourStartRatingFilled);
        click(fourStartRating);
        click(dropdownPolicy);
        isLocatorDisplayed(healthInsuranceOption);
        click(healthInsuranceOption);
        sendKey(writeAReviewText, RandomString.getAlphaNumericString(200));
        click(submitButton);

    }

    public void login(String username, String password){
        driver.get("https://wallethub.com/join/light");
        click(loginTab);
        sendKey(emailText, username);
        sendKey(passText, password);
        click(loginButton);

    }
}
