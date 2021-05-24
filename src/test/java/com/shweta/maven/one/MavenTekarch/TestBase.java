package com.shweta.maven.one.MavenTekarch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestBase {

	private static WebDriver driver;

	protected WebDriver getDriver() {
		if (driver == null) {
			initializeDriver();
		}
		return driver;
	}

	private void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("oshweta@mycompany.com");

		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("headache1234");

		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		driver.manage().window().maximize();
	}
	
	protected void closeDriver() {
		System.out.println("Closing driver in 5s");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//
		}
		driver.close();
		driver = null;
	}
}
