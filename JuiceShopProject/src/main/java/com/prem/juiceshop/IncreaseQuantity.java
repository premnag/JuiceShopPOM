package com.prem.juiceshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncreaseQuantity {
	
	static String URL =("https://juice-shop.herokuapp.com/#/login");
	static WebDriver driver;
	
	
	public static void preCondition() {

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().activeElement(); 
		WebElement dismissButton=driver.findElement(By.xpath("//*[contains(text(),'Dismiss')]/ancestor::button")); 
		dismissButton.click();
		
		WebElement loginEmailId = driver.findElement(By.xpath("//*[@id='email']"));
		loginEmailId.sendKeys("premkumar.nagarajan95@gmail.com");

		WebElement loginPassword = driver.findElement(By.xpath("//*[@id=\'password\']"));
		loginPassword.sendKeys("Password123");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginButton']"));
		loginButton.click();
		
	}

	public static void main(String[] args) throws InterruptedException {

		preCondition();
		
		
		
		WebElement onlyOneLeft = driver.findElement(By.xpath("//span[contains(text(),'Only 1 left')]/following::div[4][contains(text(),'Salesman')]/following::div[2]/button"));
		onlyOneLeft.click();
		
		WebElement yourBasket = driver.findElement(By.xpath("//span[contains(text(),' Your Basket')]"));
		yourBasket.click();
		
		WebElement addItem = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-plus-square fa-w-14']"));
		addItem.click();
		
		Thread.sleep(2000);		
		WebElement warningContent= driver.findElement(By.xpath("//span[contains(text(),'inconvenience')]"));
		String warningMessage = warningContent.getAttribute("textContent");
		System.out.println(warningMessage);
		
		driver.quit();
	}

}
