package com.shweta.maven.one.MavenTekarch;

import java.util.Set;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;

public class TC08 extends UserMenuDropDown {

	public void tc08() throws InterruptedException {

		String mainWindow = getDriver().getWindowHandle();

		WebElement developerConsole = getDriver().findElement(
				ByXPath.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[3]"));
		Thread.sleep(1000);

		Set<String> getAllWindows = getDriver().getWindowHandles();

		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		developerConsole.click();

		for (String window : getWindow) {

			getDriver().switchTo().window(window);
			Thread.sleep(1000);
			getDriver().getWindowHandle();
			closeDriver();
		}	
			/*if (getDriver().getWindowHandle().contentEquals(mainWindow)) {

				getDriver().getWindowHandle();
				Thread.sleep(1000);
			} else {
				getDriver().getWindowHandle();
				
			}
			closeDriver();	
		}*/
		
		getDriver().switchTo().window(mainWindow);

	}

	public static void main(String[] args) throws InterruptedException {

		TC08 testCase = new TC08();
		testCase.userMenuDrop();
		testCase.tc08();
	//	testCase.closeDriver();
		

	}
}
