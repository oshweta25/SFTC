package com.shweta.maven.one.MavenTekarch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import freemarker.log.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

	
	public static void enterText(WebElement obj, String textval, String objName) throws InterruptedException {

		if (obj.isDisplayed()) {
			Thread.sleep(4000);
			obj.sendKeys(textval);
			System.out.println("pass: " + textval + " value is entered in " + objName + " filed.");
		} else {
			System.out.println("fail: " + objName + "field does not exist, please check application.");
		}

	}
	
	public static void clickObj(WebElement ele, String ObjectName ) {
		if ( ele.isDisplayed() ) {
			ele.click();
			System.out.println(ObjectName + " was clicked.");
		}
		else {
			System.out.println(ObjectName + " couldn't be located on the webpage.");
		}
	}

}
