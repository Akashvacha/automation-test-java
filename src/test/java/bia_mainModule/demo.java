package bia_mainModule;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class demo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        	
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        WebDriverWait commonWait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://alrajhi-sit.ascentbusiness.com/main/dashboard");
        
        login(driver);
        navigateToEntitySelection(driver, commonWait, Wait);
        scrollToElementAndClick(driver, commonWait, "//*[@id=\"content-wrap\"]/div/app-business-impact/div/app-base-table/div/p-table/div/div[2]/table/tbody/tr/td[11]/button[2]");
        enterBiaDetails(driver, commonWait);

        navigateToNextPage(driver, commonWait);
        navigateToNextPage(driver, commonWait);
        navigateToNextPage(driver, commonWait);

        selectCallTreeMember(driver);
        
        navigateToNextPage(driver, commonWait);
        navigateToNextPage(driver, commonWait);
        
    }

    private static void login(WebDriver driver) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.id("kc-login"));
        loginButton.click();
    }

    private static void navigateToEntitySelection(WebDriver driver, WebDriverWait commonWait, WebDriverWait wait) {
        clickWithScroll(driver, wait, "//*[@id=\"menu-wrap\"]/div[2]/p-panelmenu/div/div[2]/div/a");
        clickElement(driver, commonWait, "//*[@id=\"content-wrap\"]/div/app-business-impact/div/div/p-multiselect/div/div[2]/div");
        sendKeysToElement(driver, "automation test", "//*[@id=\"content-wrap\"]/div/app-business-impact/div/div/p-multiselect/div/div[4]/div[1]/div[2]/input");
        clickElement(driver, commonWait, "//*[@id=\"content-wrap\"]/div/app-business-impact/div/div/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem/li");
        clickElement(driver, commonWait, "//*[@id=\"content-wrap\"]/div/app-business-impact/div/div/p-multiselect/div/div[4]/div[1]/button");
    }

    private static void scrollToElementAndClick(WebDriver driver, WebDriverWait commonWait, String xpath) {
        WebElement scrollableElement = commonWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollableElement);
        scrollableElement.click();
    }

    private static void enterBiaDetails(WebDriver driver, WebDriverWait commonWait) {
        sendKeysToElement(driver, "automation descp", "//*[@id=\"content-wrap\"]/div/bia-process/div/bia-detail/div/form/div/div[2]/textarea");
        sendKeysToElement(driver, "automation001", "//*[@id=\"content-wrap\"]/div/bia-process/div/bia-detail/div/form/div/div[4]/input");
        sendKeysToElement(driver, "123", "//*[@id=\"content-wrap\"]/div/bia-process/div/bia-detail/div/form/div/div[7]/input");
    }

    private static void navigateToNextPage(WebDriver driver, WebDriverWait commonWait) {
        navigateToNextPage(driver, commonWait, "//*[@id=\"content-wrap\"]/div/bia-process/div/div/div[2]/p-button/button");
    }

    private static void navigateToNextPage(WebDriver driver, WebDriverWait commonWait, String xpath) {
        clickElement(driver, commonWait, xpath);
    }

    private static void selectCallTreeMember(WebDriver driver) {
        clickElement(driver, null, "//*[@id=\"content-wrap\"]/div/bia-process/div/call-tree/app-base-table/div/p-table/div/div[2]/table/tbody/tr[6]/td[1]/p-checkbox/div/div[2]/span");
    }

    private static void clickElement(WebDriver driver, WebDriverWait commonWait, String xpath) {
        clickElement(driver.findElement(By.xpath(xpath)), commonWait);
    }

    private static void clickElement(WebElement element, WebDriverWait commonWait) {
        commonWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void clickElement(String xpath, WebDriver driver) {
        clickElement(driver.findElement(By.xpath(xpath)));
    }

    private static void clickElement(WebElement element) {
        element.click();
    }

    private static void sendKeysToElement(WebDriver driver, String keys, String xpath) {
        sendKeysToElement(driver.findElement(By.xpath(xpath)), keys);
    }

    private static void sendKeysToElement(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    private static void clickWithScroll(WebDriver driver, WebDriverWait commonWait, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
