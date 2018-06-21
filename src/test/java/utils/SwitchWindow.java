package utils;

import org.openqa.selenium.WebDriver;

public class SwitchWindow {
	public static void nextWindow(WebDriver driver) {
		String current = driver.getWindowHandle();
		
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

}
