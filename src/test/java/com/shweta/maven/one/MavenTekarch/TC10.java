package com.shweta.maven.one.MavenTekarch;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import freemarker.log.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC10 extends ReusableMethods {

		static WebDriver driver;	
		
		static ExtentReports reports;
		static ExtentTest logger;
		static String reportFolder = "/Users/sanjeevojha/shweta-workspace/TestCasesSalesForce/src/test/resources/reports/";
		
		public static void initializeReport() {
			reports = new ExtentReports(reportFolder + new SimpleDateFormat( " 'SalesForceReport_'YYYYMMddHHmm'.html' " ).format(new Date()));
		
		}	
		
		public static String takeScreenshot() throws IOException {
	        TakesScreenshot srcShot = ((TakesScreenshot) driver);
	        
	        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
	        String imagePath = reportFolder + "/ScreenShots/" + new SimpleDateFormat("'Image_'YYYYMMddHHmm'.png'").format(new Date());
	        
	        File destFile = new File(imagePath);
	        FileUtils.copyFile(srcFile,destFile);
	        
	        return imagePath;
	    }
		
		public static void loginSales()  throws InterruptedException, IOException {
			initializeReport();
			logger = reports.startTest("Login");
			logger.log(LogStatus.INFO, " Test Case started");
			
			WebElement uname = driver.findElement(By.xpath(
					"//input[@id='username']"));
			enterText(uname,"oshweta@mycompany.com","UserName");
			logger.log(LogStatus.INFO, " Username entered successfully.");
			
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			enterText(pwd,"headache1234","Password");
			logger.log(LogStatus.INFO, " Password entered successfully.");
			
			WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
			clickObj(login, "Login Button");
			logger.log(LogStatus.INFO, " Login button was clicked successfully");

			Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Testcase passed, see the attached screenshot. \r\n" +
						logger.addScreenCapture(takeScreenshot()));
			
			reports.endTest(logger);
		}
		
		
		
			
	public static void main(String[] args) throws InterruptedException, IOException  {
	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
		initializeReport();
		takeScreenshot();	
		loginSales();
		reports.flush();
				
				
		Thread.sleep(2000);
		driver.close();
	}

}
