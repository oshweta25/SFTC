package com.shweta.maven.one.MavenTekarch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC14 extends ReusableMethods{

	public static void tc14() throws IOException, InterruptedException {
		
		logger = reports.startTest("Activity Accounts");
		
		WebElement acc30 = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		clickObj(acc30, "Clicked on Account with activity greater than 30 days.");
		logger.log(LogStatus.INFO, "Clicked on Account with activity greater than 30 days.");
		
		Thread.sleep(500);
		//WebElement noThanks = driver.findElement(By.id("ext-gen189"));		
		/*
		 * Thread.sleep(500); if ( driver.findElement(By.id("ext-gen189")).isDisplayed()
		 * ) { clickObj(driver.findElement(By.id("ext-gen189")),
		 * "No Thanks clicked in Popup Window"); logger.log(LogStatus.INFO,
		 * "No Thanks clicked in Popup Window"); }
		 */
		logger.log(LogStatus.INFO, "Unsaved Reports Page is Displayed.");
		
		
		WebElement dateSelect = driver.findElement(By.id("ext-gen20"));
		clickObj(dateSelect, "Date field clicked.");

		WebElement createDate = driver.findElement(By.xpath("//*[@id=\"ext-gen265\"]/div[3]"));
		clickObj(createDate, "Create Date clicked");		
		
		//Today selection from FROM field
		WebElement cal = driver.findElement(By.id("ext-gen152"));
		clickObj(cal, "Calendar clicked");		
		WebElement today1 = driver.findElement(By.id("ext-gen281"));
		clickObj(today1, "today clicked in from field");
		
		//Today selection from TO field
		WebElement cal2 = driver.findElement(By.id("ext-gen154"));
		clickObj(cal2, "Calendar2 clicked");		
		WebElement today2 = driver.findElement(By.id("ext-gen296"));
		clickObj(today2, "today clicked in To field");
		
		//save
		WebElement save = driver.findElement(By.id("ext-gen49"));
		clickObj(save, "save clicked");
		
		//fill fields in pop up  
		WebElement reportName = driver.findElement(By.id("saveReportDlg_reportNameField"));
		enterText(reportName, "Report1", "Report Name");
		WebElement uniqueName = driver.findElement(By.id("saveReportDlg_DeveloperName"));
		enterText(uniqueName, "UniqueReport1", "Unique Report Name");
		
		WebElement saveNRun = driver.findElement(By.id("ext-gen347"));
		clickObj(saveNRun, "Save And Run clicked");
		
		Thread.sleep(3500);
		  logger.log(LogStatus.INFO,
		  "Test for accounts with activity greater than 30 days saved and run successfully. \r\n"
		  + logger.addScreenCapture(takeScreenshot()));
		 
		reports.endTest(logger);
		
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		initializeReport();
		takeScreenshot();
		TC10.goToAccountsTab();
		tc14();

		reports.flush();

		Thread.sleep(3000);
		driver.close();

	}

}
