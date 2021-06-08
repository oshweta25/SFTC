package com.shweta.maven.one.MavenTekarch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC10 extends ReusableMethods {

	public static void goToAccountsTab() throws InterruptedException, IOException {
		loginSales();
		logger = reports.startTest("Navigate to Account Tab");
		logger.log(LogStatus.INFO, "Navigate to Account Tab Test Case started");
		WebElement accTab = driver.findElement(By.id("Account_Tab"));
		accTab.click();
		logger.log(LogStatus.INFO, "Account Tab Clicked");

		String actualUrl = driver.getCurrentUrl();

		Thread.sleep(500);
		WebElement closeModal = driver.findElement(By.id("tryLexDialogX"));
		if (closeModal.isDisplayed()) {
			Thread.sleep(1500);
			closeModal.click();
		}
		String expectedUrl = "https://mycompany378-dev-ed.my.salesforce.com/001/o";
		Assert.assertEquals(actualUrl, expectedUrl);
		logger.log(LogStatus.INFO,
				"Account Tab opened successfully. \r\n" + logger.addScreenCapture(takeScreenshot()));
		
		reports.endTest(logger);
	}

	public static void createNewAccount() throws InterruptedException, IOException {
		goToAccountsTab();
		logger = reports.startTest("Create New Account Test.");
		logger.log(LogStatus.INFO, "Create New Account Test Case started");

		WebElement createNewAcc = driver.findElement(By.id("createNewLabel"));
		createNewAcc.click();

		WebElement accDD = driver.findElement(By.cssSelector("a[class='accountMru menuButtonMenuLink']"));
		accDD.click();

		Assert.assertEquals(driver.getCurrentUrl(),
				"https://mycompany378-dev-ed.my.salesforce.com/001/e?retURL=%2F001%2Fo");

		WebElement accName = driver.findElement(By.cssSelector("#acc2"));
		enterText(accName, "Shweta Ojha", "NewAccoutName");
		logger.log(LogStatus.INFO, "New Account Name Entered.");

		WebElement selectMenu = driver.findElement(By.cssSelector("#acc6"));
		selectMenu.click();

		WebElement techOption = driver.findElement(By.cssSelector("option[value='Technology Partner']"));
		if (techOption.isDisplayed()) {
			techOption.click();
		}
		logger.log(LogStatus.INFO, "Technology option selected in the Type drop down field.");

		WebElement custPri = driver.findElement(By.id("00N5e000003XuK4"));
		custPri.click();

		WebElement highPri = driver.findElement(By.cssSelector("option[value='High']"));
		highPri.click();
		logger.log(LogStatus.INFO, "Customer priority set to high in priority drop down menu.");

		WebElement save = driver.findElement(By.cssSelector("input[tabIndex='34']"));
		save.click();
		logger.log(LogStatus.INFO,
				"New Customer account created successfully. \r\n" + logger.addScreenCapture(takeScreenshot()));

		reports.endTest(logger);
		// Created dynamic url each time for each new account created so, unable to dod
		// assert based on url.
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://mycompany378-dev-ed.my.salesforce.com/0015e000008xm6k");
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		initializeReport();
		takeScreenshot();
		createNewAccount();
		reports.flush();

		Thread.sleep(2000);
		driver.close();
	}

}
