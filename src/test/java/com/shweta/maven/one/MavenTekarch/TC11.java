package com.shweta.maven.one.MavenTekarch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC11 extends ReusableMethods {
			
	public static void createNewView() throws InterruptedException, IOException {
		
		TC10.goToAccountsTab();

		logger = reports.startTest("Create New View Test Started!");
		logger.log(LogStatus.INFO, "Create New View Test Case Started!");

		WebElement newView = driver.findElement(
				By.cssSelector("a[href=\"/ui/list/FilterEditPage?ftype=a&retURL=%2F001&cancelURL=%2F001%2Fo\"]"));
		newView.click();

		Assert.assertEquals(driver.getCurrentUrl(),
				"https://mycompany378-dev-ed.my.salesforce.com/ui/list/FilterEditPage?ftype=a&retURL=%2F001&cancelURL=%2F001%2Fo");
		logger.log(LogStatus.INFO, "Create New View Page opened successfully");

		WebElement viewName = driver.findElement(By.id("fname"));
		enterText(viewName, "newView Name", "View Name");
		logger.log(LogStatus.INFO, "New View Name added successfully");

		WebElement uniqueName = driver.findElement(By.id("devname"));
		uniqueName.clear();
		enterText(uniqueName, "A", "Unique Name");
		logger.log(LogStatus.INFO, "Unique View Name added successfully");

		
		WebElement save = driver.findElement(By.cssSelector("input[data-uidsfdc='3']"));
		clickObj(save, "New View Save cliked and saved successfully.");
		
		logger.log(LogStatus.INFO,
				"New View created successfully. \r\n" + logger.addScreenCapture(takeScreenshot()));

		reports.endTest(logger);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		initializeReport();
		takeScreenshot();
		createNewView();
		reports.flush();

		Thread.sleep(2000);
		driver.close();
		
	}

}
