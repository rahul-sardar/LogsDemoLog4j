package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLoginPageTest {

	WebDriver driver;
	Logger log = Logger.getLogger(GoogleLoginPageTest.class);
	  
	  
	  @BeforeTest
	  public void setup() {
		    System.out.println("Before Method ...SetUp method Running");
		  
			  WebDriverManager.chromedriver().setup();
			  log.debug("Running Setup method");
			  log.fatal("Checking fatal message on logs");
		      driver = new ChromeDriver();  
			  driver.get("https://accounts.google.com/signin");
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.manage().window().maximize();	  
	  }
	  
	  @Test
	  public void titleTest() {
		  Assert.assertEquals(driver.getTitle(), "Sign in – Google accounts");
		  log.error("checking error message in tiltle test");
		  log.info("Checking info message on log");
	  }
	  
	  @Test
	  public void emailPhoneField() {
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@type='email']")).isDisplayed());
	  }
	  
	  @Test
	  public void nextButton() {
		  Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed());
	  }
	  
	  @AfterTest
	  public void tearDown() {
		  driver.quit();
	  }
	
}
