package alraji_system_admin_bia_creation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.BiaChannelPage;
import common.BiaProductPage;

public class createChannelProductServieForBia {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://alrajhi-sit.ascentbusiness.com/main/dashboard");

		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));

		usernameField.sendKeys("admin");
		passwordField.sendKeys("admin");

		WebElement loginButton = driver.findElement(By.id("kc-login"));
		loginButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement sysAdminEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/app-root/app-layout/div/app-menu/div/div[2]/p-panelmenu/div/div[15]/div[1]/a/span[3]")));
		clickWithScroll(driver, sysAdminEle);

		WebElement bia = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[4]/a/span[3]")));
		clickWithScroll(driver, bia);

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// channel for bia

		WebElement channelELe = driver.findElement(
				By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[4]/p-panelmenusub/ul/li[6]/a/span[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", channelELe);

		WebDriverWait channelWait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement addNewChannel = channelWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-channels/app-base-table/div/p-table/div/div[1]/div/div[2]/div[2]/button")));
		addNewChannel.click();

		WebElement channelName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		channelName.sendKeys("dummy channel");

		WebElement channelEntity = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-channels/app-base-table/app-entity-form/p-dialog/div/div/div[2]/form/div/div[2]/div/p-multiselect/div/div[2]"));
		channelEntity.click();

		// search filter for required entity
//				WebElement channelEntitySearchForOne = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/input"));
//				channelEntitySearchForOne.sendKeys("automation test");

//				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
//				WebElement selectRequiredEntity = wait2
//						.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/ul/p-multiselectitem/li/span")));
//				selectRequiredEntity.click();

		// default select all entity
		WebElement channelEntitySearchForAll = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]"));
		channelEntitySearchForAll.click();

		WebElement closeChannelEntityDropDownBtn = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closeChannelEntityDropDownBtn.click();

		WebElement channelDesc = driver.findElement(By.xpath("//*[@id=\"desc\"]"));
		channelDesc.sendKeys("channel descp");

		WebElement channelSaveBtn = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-channels/app-base-table/app-entity-form/p-dialog/div/div/div[3]/button[2]"));
		channelSaveBtn.click();

		try {
			Thread.sleep(2000); // 2000 milliseconds = 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		BiaChannelPage biaChannelPage = new BiaChannelPage(driver);
//		biaChannelPage.navigateToChannelPage();
//		biaChannelPage.addNewChannel();
//		biaChannelPage.fillChannelDetails("dummy channel", "channel descp");

		// products for bia

//		BiaProductPage biaProductPage = new BiaProductPage(driver);
//		biaProductPage.navigateToProductPage();
//		biaProductPage.addNewProduct();
//		biaProductPage.fillProductDetails("dummy product");
//		biaProductPage.selectProductEntity("automaton test");
//		biaProductPage.selectProductOwner();
//		biaProductPage.selectProductBackupOwner();
//		biaProductPage.descp("dummy descp");
//		biaProductPage.close();

		WebElement productELe = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[4]/p-panelmenusub/ul/li[7]/a/span[2]")));
		JavascriptExecutor productExecutor = (JavascriptExecutor) driver;
		productExecutor.executeScript("arguments[0].click();", productELe);

		WebDriverWait productWait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement addNewProduct = productWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-product/app-base-table/div/p-table/div/div[1]/div/div[2]/div[2]/button")));
		addNewProduct.click();

		WebElement productName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		productName.sendKeys("dummy name");

		WebElement productEntitySearch = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-product/app-base-table/app-entity-form/p-dialog/div/div/div[2]/form/div/div[2]/div/p-multiselect/div/div[2]"));
		productEntitySearch.click();

		WebElement productEntityname = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/input"));
		productEntityname.sendKeys("automation test");

		WebElement productEntitySelect = driver
				.findElement(By.xpath("/html/body/div/div[2]/ul/p-multiselectitem/li/span"));
		productEntitySelect.click();

		WebElement closeentitytab = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closeentitytab.click();

		WebElement productOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-product/app-base-table/app-entity-form/p-dialog/div/div/div[2]/form/div/div[3]/div/p-multiselect/div/div[2]"));
		productOwner.click();

		WebElement selectOwner = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]"));
		selectOwner.click();

		WebElement closeowner = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closeowner.click();

		WebElement productBackupOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-product/app-base-table/app-entity-form/p-dialog/div/div/div[2]/form/div/div[4]/div/p-multiselect/div/div[2]/div"));
		productBackupOwner.click();

		WebElement selectBackupOwner = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]"));
		selectBackupOwner.click();

		WebElement closebackupowner = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closebackupowner.click();

		WebElement productDescp = driver.findElement(By.xpath("//*[@id=\"desc\"]"));
		productDescp.sendKeys("product descp");

		WebElement closeTab = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-bia-product/app-base-table/app-entity-form/p-dialog/div/div/div[3]/button[2]"));
		closeTab.click();

		try {
			Thread.sleep(2000); // 2000 milliseconds = 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// services for bia

		WebElement serviceEle = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"undefined_content\"]/p-panelmenusub/ul/li[4]/p-panelmenusub/ul/li[8]/a/span[2]")));
		JavascriptExecutor serviceExecutor = (JavascriptExecutor) driver;
		serviceExecutor.executeScript("arguments[0].click();", serviceEle);

		WebDriverWait serviceWait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement newService = serviceWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-services/app-base-table/div/p-table/div/div[1]/div/div[2]/div[2]/button")));
		newService.click();

		WebElement serviceName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		serviceName.sendKeys("dummy Service");

		WebElement serviceEntitySearch = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-services/app-base-table/app-entity-form/p-dialog/div/div/div[2]/form/div/div[2]/div/p-multiselect/div/div[2]/div"));
		serviceEntitySearch.click();

		WebElement serviceEntityName = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/input"));
		serviceEntityName.sendKeys("automation test");

		WebElement serviceEntitySelect = driver
				.findElement(By.xpath("/html/body/div/div[2]/ul/p-multiselectitem/li/span"));
		serviceEntitySelect.click();

		WebElement closeServiceEntityTab = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closeServiceEntityTab.click();

		WebElement ServiceProductOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-services/app-base-table/app-entity-form/p-dialog/div/div/div[2]/form/div/div[3]/div/p-multiselect/div/div[2]/div"));
		ServiceProductOwner.click();

		WebElement selectServiceOwner = driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[1]/div[2]"));
		selectServiceOwner.click();

		WebElement closeServiceOwner = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		JavascriptExecutor ServiceExe = (JavascriptExecutor) driver;
		ServiceExe.executeScript("arguments[0].click();", closeServiceOwner);

		WebElement serviceBackupOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-services/app-base-table/app-entity-form/p-dialog/div/div/div[2]/form/div/div[4]/div/p-multiselect/div/div[2]/div"));
		serviceBackupOwner.click();

		WebElement selectServiceBackupOwner = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]"));
		selectServiceBackupOwner.click();

		WebElement closeServiceBackOwner = driver.findElement(By.xpath("/html/body/div/div[1]/button"));
		closeServiceBackOwner.click();

		WebElement ServiceDescp = driver.findElement(By.xpath("//*[@id=\"desc\"]"));
		ServiceDescp.sendKeys("product descp");

		WebElement saveService = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-services/app-base-table/app-entity-form/p-dialog/div/div/div[3]/button[2]"));
		saveService.click();

	}

	private static void clickWithScroll(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
}
