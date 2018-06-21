package tests;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceProject {
	WebDriver driver;
	
	@BeforeClass
	public void setProperty() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void doVerification() {
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys("Java Developer");
		driver.findElement(By.id("search-field-location")).clear();
	    driver.findElement(By.id("search-field-location")).sendKeys("New York");
	    driver.findElement(By.id("findTechJobs")).click();
	  
	    
	}
	
	@AfterClass
	public void close() {
		driver.close();
		System.out.println("TEST COMPLETED: " + LocalDateTime.now());
	}
	
	
	@BeforeMethod
	public void getSite() {
		driver.get("https://www.dice.com/");
		// or window().fullscreen();
		driver.manage().window().maximize();
		// set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
