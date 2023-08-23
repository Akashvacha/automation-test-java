package bia_mainModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class biaMainModule {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://alrajhi-sit.ascentbusiness.com/main/dashboard");

		login(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

		WebDriverWait commonWait = new WebDriverWait(driver, Duration.ofSeconds(2));

		WebElement mainBia = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"menu-wrap\"]/div[2]/p-panelmenu/div/div[2]/div/a")));
		clickWithScroll(driver, mainBia);

		WebElement clickEntitySearch = commonWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/app-business-impact/div/div/p-multiselect/div/div[2]/div")));
		clickEntitySearch.click();

		WebElement searchEntity = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-business-impact/div/div/p-multiselect/div/div[4]/div[1]/div[2]/input"));
		searchEntity.sendKeys("automation test");

		WebElement selectEntity = commonWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-business-impact/div/div/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem/li")));
		selectEntity.click();

		WebElement closeGlobalSearch = commonWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-business-impact/div/div/p-multiselect/div/div[4]/div[1]/button")));
		closeGlobalSearch.click();

		WebElement scrollableElement = commonWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"content-wrap\"]/div/app-business-impact/div/app-base-table/div/p-table/div/div[2]/table/tbody/tr/td[11]/button[2]")));

		// Scroll to a specific element
		int scrollAmount = 1400;
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "window.scrollTo(window.pageXOffset + arguments[0], window.pageYOffset);";
		jsExecutor.executeScript(script, scrollAmount);
		scrollableElement.click();

		WebElement biaDescp = commonWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/bia-detail/div/form/div/div[2]/textarea")));
		biaDescp.sendKeys("automation descp");

		WebElement biaUniqueSuffixCode = driver.findElement(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/bia-detail/div/form/div/div[4]/input"));
		biaUniqueSuffixCode.sendKeys("automation001");

		WebElement biaNoOfEmp = driver.findElement(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/bia-detail/div/form/div/div[7]/input"));
		biaNoOfEmp.sendKeys("123");

		// Navigate to Next Page
		WebElement nextPage = commonWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/div/div[2]/p-button/button")));
		nextPage.click();

		// Navigate to Next Page
		WebElement nextPageLoc = commonWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/div/div[2]/p-button/button")));
		nextPageLoc.click();

		// Navigate to Next Page
		WebElement nextPageCallTree = commonWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/div/div[2]/p-button/button")));
		nextPageCallTree.click();

		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement selectCallTree = load.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/app-root/app-layout/div/div[2]/div/bia-process/div/call-tree/app-base-table/div/p-table/div/div[2]/table/thead/tr/th[1]/p-checkbox")));
		selectCallTree.click();

		// Navigate to Next Page
		WebElement nextPageAppiCallTree = commonWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/div/div[2]/p-button/button")));
		nextPageAppiCallTree.click();

		// Navigate to Next Page
		WebElement nextPageProcess = commonWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/div/div[2]/p-button/button")));
		nextPageProcess.click();

		WebElement processName = commonWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[1]/input")));
		processName.sendKeys("auto process");

		WebElement processDescp = driver.findElement(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[2]/textarea"));
		processDescp.sendKeys("auto descp");

		WebElement processChannel = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div[1]/form/div/div[3]/p-multiselect/div/div[2]/div"));
		processChannel.click();

		WebElement selectProcessChannel = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div[1]/form/div/div[3]/p-multiselect/div/div[4]/div[1]/div[1]"));
		selectProcessChannel.click();

		WebElement closeProcessChannel = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div[1]/form/div/div[3]/p-multiselect/div/div[4]/div[1]/button"));
		closeProcessChannel.click();

		WebElement processProducts = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[4]/p-multiselect/div/div[2]"));
		processProducts.click();

		WebElement selectProcessProducts = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[4]/p-multiselect/div/div[4]/div[1]/div[1]/div[2]"));
		selectProcessProducts.click();

		WebElement closeProcessProducts = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[4]/p-multiselect/div/div[4]/div[1]/button"));
		closeProcessProducts.click();

		WebElement processServices = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[5]/p-multiselect/div/div[2]"));
		processServices.click();

		WebElement selectProcessServices = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div[1]/form/div/div[5]/p-multiselect/div/div[4]/div[1]/div[1]"));
		selectProcessServices.click();

		WebElement closeProcessServices = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[5]/p-multiselect/div/div[4]/div[1]/button"));
		closeProcessServices.click();

		WebElement processOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[2]"));
		processOwner.click();

		WebElement processselectOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div[1]/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[2]"));
		processselectOwner.click();

//		String[] ownersToSelect = {
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[1]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[2]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[3]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[4]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[5]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[6]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[7]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[8]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[9]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[10]" };
//
//		// Select elements for the processOwner multiselect
//		for (int i = 0; i < Math.min(2, ownersToSelect.length); i++) {
//			WebElement ownerElement = commonWait
//					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ownersToSelect[i])));
//			ownerElement.click();
//		}

		WebElement processOwnerClose = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[1]/button"));
		processOwnerClose.click();

		WebElement processBackUpOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[7]/p-multiselect/div/div[2]"));
		processBackUpOwner.click();

		WebElement processselectBackUpOwner = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[7]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[4]"));
		processselectBackUpOwner.click();

//		String[] backUpOwnersToSelect = {
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[1]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[2]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[3]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[4]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[5]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[6]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[7]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[8]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[9]",
//				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[6]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[10]" };
//
//		// Select elements for the processBackUpOwner multiselect
//		for (int i = 2; i <= backUpOwnersToSelect.length - 5; i++) {
//			WebElement backUpOwnerElement = commonWait
//					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(backUpOwnersToSelect[i])));
//			backUpOwnerElement.click();
//		}

		WebElement processBackUpOwnerClose = driver.findElement(By.xpath(
				"//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/div/div[7]/p-multiselect/div/div[4]/div[1]/button"));
		processBackUpOwnerClose.click();

		WebElement saveProcess = driver
				.findElement(By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/processes/div/form/button"));
		saveProcess.click();

		// peaktimes and critical deadlines

		WebElement addNewPeakTime = commonWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"process-level-tabs\"]/peak-time/app-base-table[1]/div/p-table/div/div[1]/div/div[2]/div[2]/button")));
		addNewPeakTime.click();

		WebElement startPeakTImeBtn = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/peak-time/p-dialog[1]/div/div/div[2]/form/div[1]/ngx-cron-input/div/div[1]/ngx-button[1]/button"));
		startPeakTImeBtn.click();

		WebElement endPeakTImeBtn = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/peak-time/p-dialog[1]/div/div/div[2]/form/div[2]/ngx-cron-input/div/div[1]/ngx-button[1]/button"));
		endPeakTImeBtn.click();

		WebElement ptDescp = driver.findElement(By.xpath("//*[@id=\"descriptionPT\"]"));
		ptDescp.sendKeys("automation descp added");

		WebElement savePT = driver.findElement(
				By.xpath("//*[@id=\"process-level-tabs\"]/peak-time/p-dialog[1]/div/div/div[3]/p-button[2]/button"));
		savePT.click();

		WebElement addNewCriticalDeadline = commonWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"process-level-tabs\"]/peak-time/app-base-table[2]/div/p-table/div/div[1]/div/div[2]/div[2]/button")));
		addNewCriticalDeadline.click();

		WebElement startCriticalDeadlineBtn = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/peak-time/p-dialog[2]/div/div/div[2]/form/div[1]/ngx-cron-input/div/div[1]/ngx-button[1]/button"));
		startCriticalDeadlineBtn.click();

		WebElement endCriticalDeadlineBtn = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/peak-time/p-dialog[2]/div/div/div[2]/form/div[2]/ngx-cron-input/div/div[1]/ngx-button[1]/button"));
		endCriticalDeadlineBtn.click();

		WebElement cdDescp = driver.findElement(By.xpath("//*[@id=\"descriptionCD\"]"));
		cdDescp.sendKeys("automation descp added");

		WebElement saveCD = driver.findElement(
				By.xpath("//*[@id=\"process-level-tabs\"]/peak-time/p-dialog[2]/div/div/div[3]/p-button[2]/button"));
		saveCD.click();

		// next page button (impact page)
		WebDriverWait waitForBtn = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement nextPageImpact = waitForBtn.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/div/div[2]/p-button/button")));
		nextPageImpact.click();

		// impact page

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement financialService = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"process-level-tabs\"]/impact/form/p-table/div/div[1]/table/tbody/tr[1]/td[3]/p-dropdown/div/span")));
		financialService.click();

		WebElement addFinancialService = driver.findElement(By.xpath("/html/body/div/div/ul/p-dropdownitem[3]/li"));
		addFinancialService.click();

		WebElement selectReputationalRisk = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/impact/form/p-table/div/div[1]/table/tbody/tr[2]/td[3]/p-dropdown/div/span"));
		selectReputationalRisk.click();

		WebElement addReputationalRisk = driver.findElement(By.xpath("/html/body/div/div/ul/p-dropdownitem[3]/li"));
		addReputationalRisk.click();

		WebElement selectInfrastructureServices = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/impact/form/p-table/div/div[1]/table/tbody/tr[3]/td[3]/p-dropdown/div/span"));
		selectInfrastructureServices.click();

		WebElement addInfrastructureServices = driver
				.findElement(By.xpath("/html/body/div/div/ul/p-dropdownitem[2]/li"));
		addInfrastructureServices.click();

		WebElement findRto = driver
				.findElement(By.xpath("//*[@id=\"process-level-tabs\"]/impact/form/div[1]/div/button"));
		findRto.click();

		WebElement addMBCOPercent = driver.findElement(
				By.xpath("//*[@id=\"process-level-tabs\"]/impact/form/div[2]/div/div[1]/p-inputnumber/span/button[1]"));
		addMBCOPercent.click();

		// if you want overRide RTO

//		WebElement ifOverRIdeRTOClicked = driver.findElement(By.xpath(
//				"//*[@id=\"process-level-tabs\"]/impact/form/div[2]/div/div[8]/div/p-checkbox/div/div[2]/span"));
//		ifOverRIdeRTOClicked.click();
//		
//		WebElement addOverRideRTOTime = driver.findElement(By.xpath(
//				"//*[@id=\"process-level-tabs\"]/impact/form/div[2]/div/div[9]/p-dropdown/div/span"));
//		addOverRideRTOTime.click();
//		
//		WebElement selectedOverRideRTOTime = driver.findElement(By.xpath(
//				"/html/body/div/div/ul/p-dropdownitem[2]/li"));
//		selectedOverRideRTOTime.click();
//		
//		WebElement addJustification = driver.findElement(By.xpath(
//				"//*[@id=\"process-level-tabs\"]/impact/form/div[2]/div/div[10]/textarea"));
//		addJustification.sendKeys("auto justify");

		// next page dependencies
		WebElement nextPageDepen = driver
				.findElement(By.xpath("//*[@id=\"content-wrap\"]/div/bia-process/div/div/div[2]/p-button/button"));
		nextPageDepen.click();

		// dependencies => internal dependency

		WebElement addNewInternalDepen = waitForBtn.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/div[2]/button")));
		addNewInternalDepen.click();

		WebElement selectDependencyType = waitForBtn.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[1]/p-dropdown/div/span")));
		selectDependencyType.click();

		// if its within function

		// if its outside function
		WebElement addOutsideFunction = waitForBtn
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/ul/p-dropdownitem[2]/li")));
		addOutsideFunction.click();

		WebElement dependencyFunction = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[3]/p-dropdown/div/span"));
		dependencyFunction.click();

		WebElement selectdependencyFunction = driver
				.findElement(By.xpath("/html/body/div/div/ul/p-dropdownitem[1]/li"));
		selectdependencyFunction.click();

		WebElement dependencyProcess = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[4]/p-dropdown/div/span"));
		dependencyProcess.click();

		WebElement selectdependencyProcess = waitForBtn
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/ul/p-dropdownitem")));
		clickWithScroll(driver, selectdependencyProcess);

		WebElement location = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[5]/p-multiselect/div/div[2]/div"));
		location.click();

		WebElement selectLoc = waitForBtn
				.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[5]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[1]")));
		selectLoc.click();

		WebElement primaryContact = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[7]/input"));
		primaryContact.sendKeys("ascent");

		WebElement secondaryContact = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[7]/input"));
		secondaryContact.sendKeys("ascent IT deprt");

		WebElement rto = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[10]/p-dropdown/div/span"));
		rto.click();

		WebElement selectRto = driver.findElement(By.xpath("/html/body/div/div/ul/p-dropdownitem[2]"));
		selectRto.click();

		WebElement dependencyCriteria = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[11]/p-dropdown/div/span"));
		dependencyCriteria.click();

		WebElement selectdependencyCriteria = driver.findElement(By.xpath("/html/body/div/div/ul/p-dropdownitem[1]"));
		selectdependencyCriteria.click();

		WebElement description = driver.findElement(By.xpath(
				"//*[@id=\"process-level-tabs\"]/app-dependencies/app-internal-dependencies/form/p-dialog/div/div/div[2]/div/div[12]/textarea"));
		description.sendKeys("descp");

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
