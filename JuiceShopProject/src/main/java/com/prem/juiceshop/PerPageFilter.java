package com.prem.juiceshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PerPageFilter {

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
		
		WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='mat-select-value-1']"));
		dropDownMenu.click();
		
		WebElement dropDownChoiceSelection = driver.findElement(By.xpath("//span[contains(text(),'24')]"));
		dropDownChoiceSelection.click();
		
				
		WebElement dropDownMenu1 = driver.findElement(By.xpath("//*[@id='mat-select-value-1']"));
		dropDownMenu1.click();
		
		WebElement dropDownChoiceSelection1 = driver.findElement(By.xpath("//span[contains(text(),'36')]"));
		dropDownChoiceSelection1.click();
		
		driver.close();

	}

}
