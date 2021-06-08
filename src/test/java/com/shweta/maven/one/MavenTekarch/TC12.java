package com.shweta.maven.one.MavenTekarch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC12 extends ReusableMethods {
	
	public static void tc12() throws InterruptedException, IOException {
	
	logger = reports.startTest("Edit View");	

	WebElement viewDD = driver.findElement(By.id("fcf"));
	clickObj(viewDD, "Select view option field opened upon click");
	logger.log(LogStatus.INFO, "Select view option field opened upon click");

	//this will select efd
	WebElement selectView = driver.findElement(By.cssSelector("option[value='00B5e00000ApsZS']"));
	
		clickObj(selectView, "efd View selected from select menu options.");
		logger.log(LogStatus.INFO, "efd View selected from select menu options.");
		selectView.click();
	
	
	Thread.sleep(1000);
	//This will click the edit link
	WebElement editView = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
	clickObj(editView, "Edit View Page is Displayed.");
	logger.log(LogStatus.INFO, "Edit View Page is Displayed.");
	
	//Change view name 
	WebElement viewName = driver.findElement(By.id("fname"));
	viewName.clear();
	enterText(viewName, "Hello New View name", "New view name entered");
	
	//select accounts 
	WebElement accountFilterMenu = driver.findElement(By.id("fcol1"));
	clickObj(accountFilterMenu, "Select Filter dd menu field opened upon click");
	logger.log(LogStatus.INFO, "Select Filter dd menu field opened upon click");
	
	WebElement accountFilter = driver.findElement(By.cssSelector("option[value=\"ACCOUNT.NAME\"]"));
	clickObj(accountFilter, "Account selected from select menu options in filter section.");
	
	
	//select operator 
	WebElement operatorSelect = driver.findElement(By.id("fop1"));
	clickObj(operatorSelect, "Select Operator dd menu field opened upon click");
	logger.log(LogStatus.INFO, "Select Operator dd menu field opened upon click");
	
	WebElement operatorContains = driver.findElement(By.cssSelector("option[value=\"c\"]"));
	clickObj(operatorContains, "Operator Contains selected from select menu options in filter section.");
	
	//select value
	WebElement value = driver.findElement(By.id("fval1"));
	clickObj(value, "Value input field clicked.");
	logger.log(LogStatus.INFO, "Value input field clicked.");
	value.clear();
	enterText(value, "a", "Value 'a' entered.");
	
	WebElement save = driver.findElement(By.cssSelector("input[data-uidsfdc=\"5\"]"));
	clickObj(save, "New View saved successfully.");
	
	logger.log(LogStatus.INFO,
			"Edited View saved successfully. \r\n" + logger.addScreenCapture(takeScreenshot()));

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
		TC10.goToAccountsTab();
		tc12();
		
		reports.flush();

		Thread.sleep(2000);
		driver.close();

	}
	
}
