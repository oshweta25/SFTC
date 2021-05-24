package com.shweta.maven.one.MavenTekarch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserMenuDropDown extends TestBase{
		
	protected void userMenuDrop() throws InterruptedException {
		WebElement usermenu = getDriver().findElement(By.id("userNav"));
		usermenu.click();
		Thread.sleep(3000);

	}
}
