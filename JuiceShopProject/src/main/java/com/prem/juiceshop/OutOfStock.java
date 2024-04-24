package com.prem.juiceshop;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class OutOfStock {
	
	static String URL =("https://juice-shop.herokuapp.com/#/login");
	static WebDriver driver;
	
	
	public static void preCondition() {

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().activeElement(); 
		WebElement dismissButton=driver.findElement(By.xpath("//*[contains(text(),'Dismiss')]/ancestor::button")); 
		dismissButton.click();
		
		WebElement loginEmailId = driver.findElement(By.xpath("//*[@id='email']"));
		loginEmailId.sendKeys("premkumar.nagarajan76@gmail.com");

		WebElement loginPassword = driver.findElement(By.xpath("//*[@id=\'password\']"));
		loginPassword.sendKeys("Password123");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginButton']"));
		loginButton.click();
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		preCondition();
	
	
		WebElement soldOutItem = driver.findElement(By.xpath("//span[contains(text(),'Sold Out')]/following::div[6]/button/span[1]"));
		soldOutItem	.click();

		Thread.sleep(2000);
		WebElement warningContent= driver.findElement(By.xpath("//span[contains(text(),'Sorry for the inconvenience.')]"));
		String warningMessage = warningContent.getAttribute("textContent");
		System.out.println(warningMessage);


		//driver.quit();
	}
}

