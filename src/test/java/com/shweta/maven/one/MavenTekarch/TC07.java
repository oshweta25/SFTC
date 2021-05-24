package com.shweta.maven.one.MavenTekarch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC07 extends UserMenuDropDown {

	public void tc07One() throws InterruptedException {

		WebElement mySettings = getDriver()
				.findElement(By.cssSelector("a[class='menuButtonMenuLink'][title='My Settings']"));
		mySettings.click();
		Thread.sleep(3000);
	}

	public void tc07Two() throws InterruptedException {

		WebElement personalLink = getDriver().findElement(By.id("PersonalInfo_font"));
		personalLink.click();
		Thread.sleep(3000);

		WebElement loginHistory = getDriver().findElement(By.id("LoginHistory_font"));
		loginHistory.click();
		Thread.sleep(3000);

		WebElement downloadHistory = getDriver().findElement(
				ByXPath.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
		downloadHistory.click();
		Thread.sleep(3000);

	}

	public void tc07Three() throws InterruptedException {

		WebElement display = getDriver().findElement(By.id("DisplayAndLayout_font"));
		display.click();
		Thread.sleep(3000);

		WebElement customize = getDriver().findElement(By.id("CustomizeTabs_font"));
		customize.click();
		Thread.sleep(3000);

		WebElement selectMenu = getDriver().findElement(By.id("p4"));
		Select select = new Select(selectMenu);
		select.selectByValue("02u5e0000015L6D");
		Thread.sleep(3000);

		WebElement selectMenu2 = getDriver().findElement(By.id("duel_select_0"));
		Select select2 = new Select(selectMenu2);
		select2.selectByValue("report");
		Thread.sleep(3000);

		WebElement add = getDriver().findElement(By.id("duel_select_0_right"));
		add.click();
		Thread.sleep(3000);

		WebElement save = getDriver().findElement(By.cssSelector("input[class=\"btn primary\"]"));
		save.click();

	}

	public void tc07Four() throws InterruptedException {
		WebElement email = getDriver()
				.findElement(ByXPath.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[4]/a"));
		email.click();
		Thread.sleep(3000);

		WebElement myEmailSetting = getDriver().findElement(By.id("EmailSettings_font"));
		myEmailSetting.click();
		Thread.sleep(3000);

		WebElement emailName = getDriver().findElement(By.id("sender_name"));
		emailName.clear();
		emailName.sendKeys("ShwetaOjha");
		Thread.sleep(1000);

		WebElement emailAdress = getDriver().findElement(By.id("sender_email"));
		emailAdress.clear();
		emailAdress.sendKeys("oshweta25@gmail.com");
		Thread.sleep(1000);

		List<WebElement> radio_button = getDriver().findElements(By.name("auto_bcc"));
		if (!radio_button.get(0).isSelected()) {
			radio_button.get(0).click();
		}
		Thread.sleep(2000);

		WebElement saveMyEmailSetting = getDriver().findElement(ByXPath
				.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]"));
		saveMyEmailSetting.click();
		Thread.sleep(3000);
	}

	public void tc07Five() throws InterruptedException {

		WebElement calendar = getDriver().findElement(By.id("CalendarAndReminders_font"));
		calendar.click();
		Thread.sleep(1000);

		WebElement reminders = getDriver().findElement(By.id("Reminders_font"));
		reminders.click();
		Thread.sleep(1000);

		WebElement openTestReminder = getDriver().findElement(By.id("testbtn"));
		openTestReminder.click();
		Thread.sleep(1000);

	}

	public static void main(String[] args) throws InterruptedException {
		TC07 testCase = new TC07();
		testCase.userMenuDrop();
		testCase.tc07One();
		//testCase.tc07Two();
		testCase.tc07Three();
		testCase.tc07Four();
		//testCase.tc07Five();

		testCase.closeDriver();
	}

}
