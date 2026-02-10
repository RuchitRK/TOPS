package com.Assignment.Module7;


import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class gmailLoginjUnit_12 {
    WebDriver driver;
    
    @Before
    public void setUp() {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        driver.get("https://gmail.com/");
    }
    @Test
    public void testGmailLogin() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys("test12@gmail.com");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(5000);
        WebElement passwordField = driver.findElement(By.name("Passwd"));
        passwordField.sendKeys("test12_123");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(5000);
    }
    @After
    public void browserQuit() {
        driver.quit();
    }
}
