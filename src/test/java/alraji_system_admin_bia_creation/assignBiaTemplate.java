package alraji_system_admin_bia_creation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignBiaTemplate {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://alrajhi-sit.ascentbusiness.com/main/dashboard");

		login(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement sysAdminEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/app-root/app-layout/div/app-menu/div/div[2]/p-panelmenu/div/div[15]/div[1]/a/span[3]")));
		clickWithScroll(driver, sysAdminEle);

		WebElement bia = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[4]/a/span[3]")));
		clickWithScroll(driver, bia);

		WebElement assignBia = driver.findElement(
				By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[4]/p-panelmenusub/ul/li[13]/a/span[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", assignBia);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement scrollableElement = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/p-organizationchart/div/table/tbody/tr[4]/td[17]/table/tbody/tr[1]/td/div/div")));

		int scrollAmount = 1200;

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "window.scrollTo(window.pageXOffset + arguments[0], window.pageYOffset);";
		jsExecutor.executeScript(script, scrollAmount);
		scrollableElement.click();

		WebDriverWait biaWait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement addPrefix = biaWait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[1]/div[2]/input")));
		addPrefix.sendKeys("automaton001");

		WebElement selectTemp = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[1]/div[3]/p-dropdown/div/span"));
		selectTemp.click();

		// for process level
		WebElement searchTemp = driver.findElement(By.xpath("/html/body/div/div[1]/div/input"));
		searchTemp.sendKeys("process level");

		// for location level
//		WebElement searchTemp = driver.findElement(By.xpath("/html/body/div/div[1]/div/input"));
//		searchTemp.sendKeys("location level");

		WebElement selectRequiredTemp = driver
				.findElement(By.xpath("/html/body/div/div[2]/ul/p-dropdownitem[1]/li/span"));
		selectRequiredTemp.click();

		WebElement bcCoordinator = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[1]/div[4]/p-dropdown/div/span"));
		bcCoordinator.click();

		WebElement searchBc = driver.findElement(By.xpath("/html/body/div/div[1]/div/input"));
		searchBc.sendKeys("Business Coordinator");

		WebElement clickBc = driver.findElement(By.xpath("/html/body/div/div[2]/ul/p-dropdownitem"));
		clickBc.click();

		WebElement bcCoordinatorUser = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[1]/div[5]/p-multiselect/div/div[2]/div"));
		bcCoordinatorUser.click();

		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement searchBcUser = wait11.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/ul/p-multiselectitem[1]/li")));
		searchBcUser.click();

		WebElement closeBcUser = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closeBcUser.click();

		WebElement impactTemp = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[1]/div[6]/p-dropdown/div/span"));
		impactTemp.click();

		WebElement selectImpactTemp = driver
				.findElement(By.xpath("/html/body/div/div[2]/ul/p-dropdownitem[3]/li/span"));
		selectImpactTemp.click();

		WebElement approver = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[2]/p-picklist/div/div[2]/ul/li[2]/div"));
		approver.click();

		WebElement selectbtn = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[2]/p-picklist/div/div[3]/button[1]"));
		selectbtn.click();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement teams = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[1]/div[7]/p-multiselect/div/div[2]/div")));
		teams.click();

		WebElement selectTeams = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]"));
		selectTeams.click();

		WebElement closeTeams = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closeTeams.click();

		WebElement activityOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[1]/div[8]/p-multiselect/div/div[2]/div"));
		activityOwner.click();

		WebElement selectActivityOwner = driver
				.findElement(By.xpath("/html/body/div/div[2]/ul/p-multiselectitem[1]/li"));
		selectActivityOwner.click();

		WebElement closeActivityOwner = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closeActivityOwner.click();

		WebElement submitBiaTemp = driver.findElement(
				By.xpath("//*[@id=\"content-wrap\"]/div/app-bia-template-org-map/div/form/div/div/div[3]/button/span"));
		submitBiaTemp.click();

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
