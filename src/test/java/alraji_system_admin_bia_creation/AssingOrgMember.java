package alraji_system_admin_bia_creation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssingOrgMember {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://alrajhi-sit.ascentbusiness.com/main/dashboard");

		login(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement sysAdminEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/app-root/app-layout/div/app-menu/div/div[2]/p-panelmenu/div/div[15]/div[1]/a/span[3]")));
		clickWithScroll(driver, sysAdminEle);

		WebElement userManage = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[3]/a/span[3]")));
		clickWithScroll(driver, userManage);

		WebElement userGrpEle = driver.findElement(
				By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[3]/p-panelmenusub/ul/li[4]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", userGrpEle);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement orgUnitEle = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/app-root/app-layout/div/div[2]/div/app-usergroups/div/p-tabview/div/ul/li[2]/a/span")));
		orgUnitEle.click();

		WebElement selectEntity = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[1]/div/div/p-dropdown/div/span"));
		selectEntity.click();

		WebElement searchEntity = driver.findElement(By.xpath("/html/body/div/div[1]/div/input"));
		searchEntity.sendKeys("automation test");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement clickOnEntity = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/ul/p-dropdownitem/li")));
		clickOnEntity.click();

		// to select some of the org unit members run below code

		String[] orgMembersTOSelect = {
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[2]/div",
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[4]/div",
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[6]/div",
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[8]/div",
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[10]/div",
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[12]/div",
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[14]/div",
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[16]/div",
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[2]/ul/li[16]/div" };

		for (String xpath : orgMembersTOSelect) {
			// Find the element using the XPath and click on it
			WebElement elementToClick = driver.findElement(By.xpath(xpath));
			elementToClick.click();

			// Perform additional action by clicking the button after each XPath
			WebElement additionalButton = driver.findElement(By.xpath(
					"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[3]/button[1]"));
			additionalButton.click();
		}

		// to select all the org unit mmbers run below code

		/*
		 * WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * WebElement selectAllOrgMem =
		 * wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[2]/div/div/p-picklist/div/div[3]/button[2]"
		 * ))); selectAllOrgMem.click();
		 */

		WebElement submitBtn = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-usergroups/div/app-usergroup-only-orgunit/div/form/div[3]/p-button/button"));
		submitBtn.click();
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
