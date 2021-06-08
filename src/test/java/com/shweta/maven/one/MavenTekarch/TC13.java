package com.shweta.maven.one.MavenTekarch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13 extends ReusableMethods {

	public static void tc13() throws IOException, InterruptedException {
		
		logger = reports.startTest("Merge Accounts Test Started!");
		
		WebElement merge = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		clickObj(merge, "Merge accounts clicked");
		logger.log(LogStatus.INFO, "Merge Accounts clicked");
		
		WebElement srch = driver.findElement(By.id("srch"));
		clickObj(srch, "Clicked inside search accounts to merge.");
		logger.log(LogStatus.INFO, "Clicked inside search accounts to merge.");
		srch.clear();
		enterText(srch, "Shweta", "accountsMerge");
		
		WebElement findAcc = driver.findElement(By.cssSelector("input[value=\"Find Accounts\"]"));
		clickObj(findAcc, "Clicked find accounts button.");
		
		Thread.sleep(500);
		WebElement tr1 = driver.findElement(By.id("cid0"));
		clickObj(tr1, "1st row item checkbox selected.");
		
		WebElement tr2 = driver.findElement(By.id("cid1"));
		clickObj(tr2, "2nd row item checkbox selected.");
		
		Thread.sleep(500);
		WebElement next = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]"));
		clickObj(next, "Next button");
		Thread.sleep(500);

		WebElement merge2 = driver.findElement(By.cssSelector("input[value=\" Merge \"]"));
		clickObj(merge2, "merge button");
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		logger.log(LogStatus.INFO,
				"Accounts merged successfully. \r\n" + logger.addScreenCapture(takeScreenshot()));

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
		tc13();

		reports.flush();

		Thread.sleep(2000);
		driver.close();
	}

}
