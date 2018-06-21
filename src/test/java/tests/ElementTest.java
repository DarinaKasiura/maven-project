package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Environment;

public class ElementTest {

	public static void main(String[] args) {
		Environment.setUp();
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		
		List<WebElement> inputs = driver.findElements(By.xpath("//input"));
		List<WebElement> input = new ArrayList<>();
 		System.out.println("Size: " + inputs.size());
 		for(WebElement each: inputs) {
 			String value = each.getAttribute("type");
 			if(!(value.equals("hidden"))) {
 				input.add(each);
 			}
 			else {
 				continue;
 			}
 		}
 			System.out.println(input.size());
 			input.get(0).sendKeys("Admin");
 			input.get(1).sendKeys("admin");
 			
 			List<WebElement> links = driver.findElements(By.tagName("a"));
 			System.out.println("Size of links " + links.size());
 			
 			for(WebElement link: links) {
 				link.click();
 			}

	}

}
