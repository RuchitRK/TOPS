package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class gmailLoginTestNG_14 {
    WebDriver driver;
    @BeforeTest
    public void setupBrowser() {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void loginToGmail() throws InterruptedException {
        driver.get("https://gmail.com/");
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys("test14@gmail.com");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(3000);
        WebElement passwordField = driver.findElement(By.name("Passwd"));
        passwordField.sendKeys("test14@123");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void browserQuit() {
    	driver.quit();
    }
}