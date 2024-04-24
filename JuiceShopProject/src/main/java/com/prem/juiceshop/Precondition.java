package com.prem.juiceshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Precondition {
	
	static String URL =("https://juice-shop.herokuapp.com/#/login");
	static WebDriver driver;
	
	
	public static void preCondition() {

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().activeElement(); 
		WebElement dismissButton=driver.findElement(By.xpath("//*[contains(text(),'Dismiss')]/ancestor::button")); 
		dismissButton.click();
		
	}
	
	public static void registration() {
		
		WebElement notYetACustomerButton=driver.findElement(By.xpath("//*[@id='newCustomerLink']"));
		notYetACustomerButton.click();


		WebElement emailId= driver.findElement(By.xpath("//*[@id='emailControl']"));
		emailId.sendKeys("premkumar.nagarajan95@gmail.com");

		WebElement password
		=driver.findElement(By.xpath("//*[@id='passwordControl']"));
		password.sendKeys("Password123");


		WebElement repeatPassword =driver.findElement(By.xpath("//*[@id='repeatPasswordControl']"));
		repeatPassword.sendKeys("Password123");

		WebElement dropdownMenu= driver.findElement(By.xpath("//*[@id='mat-select-0']"));
		dropdownMenu.click();

		WebElement dropDownChoices = driver.findElement(By.xpath("//*[@id='mat-option-1']"));
		dropDownChoices.click();

		WebElement answer =driver.findElement(By.xpath("//*[@id='securityAnswerControl']"));
		answer.sendKeys("SarojaNagarajan");

		WebElement registerButton =driver.findElement(By.xpath("//*[@id='registerButton']"));
		registerButton.click();
	}
	
		public static void login() {
			
			WebElement loginEmailId = driver.findElement(By.xpath("//*[@id='email']"));
			loginEmailId.sendKeys("premkumar.nagarajan95@gmail.com");

			WebElement loginPassword = driver.findElement(By.xpath("//*[@id=\'password\']"));
			loginPassword.sendKeys("Password123");

			WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginButton']"));
			loginButton.click();
			
		}
	
	
	public static void main(String[] args) {
		preCondition();
		registration();
		login();
		
	}

}
