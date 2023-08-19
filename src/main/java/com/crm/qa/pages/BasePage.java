package com.crm.qa.pages;

import com.crm.qa.testdata.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    Wait<WebDriver> wait;

    Actions actions;


    public void sendKey(By by, String sendkey){
        WebElement revealed = driver.findElement(by);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestData.LOCATORS_WAIT));
        wait.until(d -> revealed.isDisplayed());
        revealed.sendKeys(sendkey);
    }

    public void click(By by){
        WebElement revealed = driver.findElement(by);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestData.LOCATORS_WAIT));
        wait.until(d -> revealed.isDisplayed());
        revealed.click();
    }

    public void hover(By by){
        actions = new Actions(driver);
        WebElement target = driver.findElement(by);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestData.LOCATORS_WAIT));
        wait.until(d -> target.isDisplayed());
        actions.moveToElement(target).perform();
    }

    public void isLocatorDisplayed(By by){
        WebElement target = driver.findElement(by);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestData.LOCATORS_WAIT));
        wait.until(d -> target.isDisplayed());
    }



}
