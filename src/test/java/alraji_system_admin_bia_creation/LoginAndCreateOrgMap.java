package alraji_system_admin_bia_creation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class LoginAndCreateOrgMap {

	public static void main(String[] args) throws AWTException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://alrajhi-sit.ascentbusiness.com/main/dashboard");

		login(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// for creating a org map start

		WebElement sysAdminEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/app-root/app-layout/div/app-menu/div/div[2]/p-panelmenu/div/div[15]/div[1]/a/span[3]")));
		clickWithScroll(driver, sysAdminEle);

		WebElement orgProEle = driver
				.findElement(By.xpath("//*[@id='undefined_content']/p-panelmenusub/ul/li[2]/a/span[3]"));
		clickWithScroll(driver, orgProEle);

		WebElement orgMapEle = driver.findElement(
				By.xpath("//*[@id='undefined_content']/p-panelmenusub/ul/li[2]/p-panelmenusub/ul/li[4]/a/span[2]"));
		clickWithScroll(driver, orgMapEle);

		driver.get("https://alrajhi-sit.ascentbusiness.com/main/sa/org-profile/org-map");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement scrollableElement = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-org-map/div/p-organizationchart/div/table/tbody/tr[1]/td/div/div")));

		int scrollAmount = 500;

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "window.scrollTo(window.pageXOffset + arguments[0], window.pageYOffset);";
		jsExecutor.executeScript(script, scrollAmount);
		scrollableElement.click();

		WebElement addDetailsBtn = driver
				.findElement(By.xpath("//*[@id=\"content-wrap\"]/div/app-org-map/div/p-menu/div/ul/li[3]/a/span[2]"));
		addDetailsBtn.click();

		WebElement enterName = driver.findElement(
				By.xpath("//*[@id=\"content-wrap\"]/div/app-org-map/p-dialog/div/div/div[2]/form/div/div[1]/input"));
		enterName.sendKeys("automation test");

		WebElement enterDescp = driver.findElement(
				By.xpath("//*[@id=\"content-wrap\"]/div/app-org-map/p-dialog/div/div/div[2]/form/div/div[2]/textarea"));
		enterDescp.sendKeys("automation test descp");

		WebElement clickLoc = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-org-map/p-dialog/div/div/div[2]/form/div/div[3]/p-multiselect/div/div[2]/div"));
		clickLoc.click();

		WebElement clickLocInd = driver.findElement(By.xpath("/html/body/div/div[2]/ul/p-multiselectitem[6]/li/span"));
		clickLocInd.click();

		WebElement clickCloseBtn = driver.findElement(By.xpath("/html/body/div/div[1]/button/span"));
		clickCloseBtn.click();

		WebElement uploadbtn = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-org-map/p-dialog/div/div/div[2]/form/div/div[4]/div/button/span[2]"));
		uploadbtn.click();

		WebElement upload = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-org-map/p-dialog/div/div/div[2]/form/div/div[5]/button/span"));
		upload.click();

		// for creating a org map end

		// for assigning org unit members to the created record start

		WebElement userManage = driver
				.findElement(By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[3]/a/span[3]"));
		userManage.click();

	}

	private static void clickWithScroll(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}

	private static void login(WebDriver driver) {
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));

		usernameField.sendKeys("admin");
		passwordField.sendKeys("admin");

		WebElement loginButton = driver.findElement(By.id("kc-login"));
		loginButton.click();
	}
}
