package com.shweta.maven.one.MavenTekarch;

import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "/Users/sanjeevojha/installs/chromedriver");

		WebDriver driver = null;
		try {
	
			WebDriverManager.chromedriver().setup();

			/*
			 * driver = new ChromeDriver();
			 * driver.get("https://qa-tekarch.firebaseapp.com/");
			 * 
			 * WebElement username = driver.findElement(By.id("email_field"));
			 * 
			 * username.sendKeys("admin123@gmail.com");
			 * 
			 * WebElement pwd = driver.findElement(By.id("password_field"));
			 * pwd.sendKeys("admin1234");
			 * 
			 * 
			 * WebElement button =
			 * driver.findElement(By.xpath("//*[@id='login_div']/button"));
			 * 
			 * button.click();
			 */

			// Test ID : Login Error Message - 1

			driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			/*
			 * WebElement username = driver.findElement(By.id("username"));
			 * username.sendKeys("oshweta@mycompany.com");
			 * 
			 * WebElement pwd = driver.findElement(By.id("password"));
			 * pwd.sendKeys("headache1234");
			 * 
			 * WebElement rememberMe = driver.findElement(By.id("rememberUn"));
			 * rememberMe.click();
			 * 
			 * WebElement button = driver.findElement(By.id("Login")); button.click();
			 */

			// Test ID : Login To SalesForce -2

			// Test ID : Forgot Password- 4 A

			/*
			 * WebElement forgotPWD = driver.findElement(By.id("forgot_password_link"));
			 * forgotPWD.click();
			 * 
			 * WebElement usernameForgotPWD = driver.findElement(By.id("un"));
			 * usernameForgotPWD.sendKeys("oshweta@mycompany.com");
			 * 
			 * WebElement continueButton = driver.findElement(By.id("continue"));
			 * continueButton.click();
			 */

			// Test ID : Forgot Password- 4 B

			/*
			 * WebElement username = driver.findElement(By.id("username"));
			 * username.sendKeys("123");
			 * 
			 * WebElement pwd = driver.findElement(By.id("password")); pwd.sendKeys("1234");
			 * 
			 * WebElement button = driver.findElement(By.id("Login")); button.click();
			 */

			// Test ID : TC05

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("oshweta@mycompany.com");

			WebDriverWait wait = new WebDriverWait(driver, 30);
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Forgot")));

			WebElement pwd = driver.findElement(By.id("password"));
			pwd.sendKeys("headache1234");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("Login"))));
			driver.manage().window().maximize();

			// Thread.sleep(3000);

			/*
			 * WebElement rememberMe = driver.findElement(By.id("rememberUn"));
			 * rememberMe.click();
			 */
			// Thread.sleep(3000);

			/*
			 * WebElement button = driver.findElement(By.id("Login")); button.click();
			 * 
			 * WebElement userNavButton = driver.findElement(By.id("userNavButton"));
			 * userNavButton.click();
			 * 
			 * WebElement myProfile =
			 * driver.findElement(ByXPath.xpath("//*[@id='userNav-menuItems']/a[1]"));
			 * Thread.sleep(1000); myProfile.click();
			 */

			// TC06 - 3n4
			/*
			 * WebElement editProfile = driver .findElement(ByXPath.xpath(
			 * "//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
			 * editProfile.click();
			 * 
			 * Thread.sleep(3000);
			 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(
			 * "contactInfoContentId"))); //WebElement editProfileWindow = (WebElement)
			 * driver.switchTo().frame("contactInfoContentId");
			 * //driver.findElement(By.id("aboutTab")); Thread.sleep(3000);
			 * 
			 * WebElement aboutUs = driver.findElement(By.id("aboutTab"));
			 * 
			 * aboutUs.click();
			 * 
			 * WebElement lastName = driver.findElement(By.id("lastName"));
			 * lastName.click(); Thread.sleep(2000);
			 * 
			 * lastName.clear(); Thread.sleep(2000);
			 * 
			 * lastName.sendKeys("Ojha123"); Thread.sleep(3000);
			 * 
			 * WebElement saveAll = driver.findElement(ByXPath.xpath(
			 * "//*[@id=\'TabPanel\']/div/div[2]/form/div/input[1]")); saveAll.click();
			 * Thread.sleep(3000);
			 * 
			 * driver.switchTo().defaultContent();
			 */

			// TC06-- 5

			/*
			 * WebElement post = driver.findElement(By.id("publisherAttachTextPost"));
			 * post.click(); Thread.sleep(1500);
			 */

			// Test ID : TC06

			/*
			 * Boolean isPresent =
			 * driver.findElements(By.className("cke_wysiwyg_framecke_reset")).size() > 0;
			 * 
			 * if (isPresent) { wait.until(
			 * ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.
			 * className("cke_wysiwyg_frame cke_reset")));
			 * 
			 * //WebElement textPostIframe = driver.findElement(By.
			 * className("chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders placeholder"
			 * )); WebElement textPara = driver.findElement(ByXPath.xpath("/html/body/p"));
			 * Thread.sleep(1000); textPara.click(); Thread.sleep(1000);
			 * 
			 * //textPara.perform().sendKeys("Hello, this is trial 1. Iframe loaded!");
			 * 
			 * driver.switchTo().defaultContent();
			 * 
			 * } else { WebElement textArea =
			 * driver.findElement(By.id("publishereditablearea"));
			 * 
			 * textArea.click();
			 * textArea.sendKeys("NO Iframe available this time. TextArea instead!"); }
			 * 
			 * WebElement share = driver.findElement(By.id("publishersharebutton"));
			 * share.click();
			 * 
			 * Thread.sleep(2000);
			 */

			// Test ID : TC06 --- step7
			
			/*
			 * WebElement photoUpload = driver.findElement(By.id("photoSection")); Actions
			 * action = new Actions(driver);
			 * action.moveToElement(photoUpload).build().perform(); Thread.sleep(2000);
			 * 
			 * WebElement uploadLink = driver.findElement(By.id("uploadLink")); Actions
			 * action1 = new Actions(driver); action1.moveToElement(uploadLink);
			 * action1.click().build().perform(); Thread.sleep(2000);
			 * 
			 * wait.until( ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(
			 * "uploadPhotoContentId"))); Thread.sleep(2000); WebElement fileInput =
			 * driver.findElement(By.className("fileInput"));
			 * 
			 * Actions action2 = new Actions(driver); action2.moveToElement(fileInput);
			 * Thread.sleep(1000); action2.click().build().perform(); Thread.sleep(2000);
			 * action2.sendKeys("/Users/sanjeevojha/Desktop/jsexecuter").perform();
			 * 
			 * WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:save"));
			 * save.click(); Thread.sleep(2000);
			 */

			/*
			 * WebElement uploadButton = driver.findElement(By.className("fileInput"));
			 * uploadButton.click(); Thread.sleep(2000);
			 * 
			 * driver.findElement(By.id("driver.findElement")).click();			  
			 */
						
			
			driver.switchTo().defaultContent();
			Thread.sleep(10000);

			driver.close();

		} finally {
			if (driver != null) {
				// driver.close();
			}
		}

	}

}
