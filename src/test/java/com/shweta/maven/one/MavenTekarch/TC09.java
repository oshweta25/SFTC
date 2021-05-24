package com.shweta.maven.one.MavenTekarch;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;

public class TC09 extends UserMenuDropDown {
	
	public void tc09() {
		WebElement logout = getDriver().findElement(ByXPath.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
		logout.click();
	
	}

	public static void main(String[] args) throws InterruptedException {
		
		TC09 testCase = new TC09();
		testCase.userMenuDrop();
		testCase.tc09();
		
		
		testCase.closeDriver();
	}

}
