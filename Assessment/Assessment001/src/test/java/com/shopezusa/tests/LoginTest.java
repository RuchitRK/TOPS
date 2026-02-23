package com.shopezusa.tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopezusa.base.BaseClass;
import com.shopezusa.utilities.WaitUtilities;

public class LoginTest extends BaseClass{
  @Test(priority = 1)
  public void openBrowser() throws InterruptedException {
	  test = extent.createTest("Step 1: Navigate to Login");
	  test.info("Attempting to click the Login Icon");
	  System.out.println("Now executing LoginTest.java");
	  WaitUtilities.waitForClickable(driver, (By.xpath("//*[@id=\"header-sticky\"]/div/header-inner/div[1]/div[3]/div[2]/a")));
	  WebElement loginIcon = driver.findElement(By.xpath("//*[@id=\"header-sticky\"]/div/header-inner/div[1]/div[3]/div[2]/a"));
	  Actions actions = new Actions(driver);
	  Thread.sleep(5000);
	  Action a1 = actions.moveToElement(loginIcon).keyDown(Keys.LEFT_CONTROL).click().keyUp(Keys.LEFT_CONTROL).build(); // did this because its not working properly
	  a1.perform();
	  WaitUtilities.waitForClickable(driver, (By.xpath("//*[@id=\"header-sticky\"]/div/header-inner/div[1]/div[3]/div[2]/a")));
	  loginIcon.click();
	  System.out.println("Successfully opened login page");
	  test.pass("Successfully opened login page");
  }
  @Test(priority = 2)
  public void handleSigninOtp() throws InterruptedException {
	  test = extent.createTest("Step 2: Handle OTP");
	  test.info("Entering email address");
	  System.out.println("Now executing handleSigninOtp");
	  WaitUtilities.waitForClickable(driver, (By.id("customer-authentication-web-email")));
	  driver.findElement(By.id("customer-authentication-web-email")).sendKeys("ruchitkosambiya@gmail.com");
	  Thread.sleep(1500);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  WaitUtilities.waitForClickable(driver, (By.id("TextField0")));
	  System.out.println("AUTOMATION PAUSED: Please check your email and enter the OTP here in the console, then press ENTER:");
	  Scanner sc = new Scanner(System.in);
	  String manualOtp = sc.nextLine();
	  test.info("Entering manual OTP: " + manualOtp);
	  driver.findElement(By.id("TextField0")).sendKeys(manualOtp);
	  Thread.sleep(1500);
	  driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[1]/div/button")).click();
	  sc.close();
	  System.out.println("AUTOMATION RESUMED!");
	  test.info("Clicking Shop EZ logo to return to Home");
	  WaitUtilities.waitForClickable(driver, (By.xpath("//img[@alt='Shop EZ USA logo']")));
	  driver.findElement(By.xpath("//img[@alt='Shop EZ USA logo']")).click();////*[@id="CustomProperties-:rt:"]/header/section/div/div/div/a/picture/img
	  Thread.sleep(5000);
	  test.info("Verifying redirect to the home page");
	  String expectedUrl = "https://www.shopezusa.com/?country=US";
      String actualUrl = driver.getCurrentUrl();
      Assert.assertEquals(actualUrl, expectedUrl, "Failure: User was not redirected to the home page");
	  test.pass("Successfully handled OTP and returned to homepage");
	}
}
