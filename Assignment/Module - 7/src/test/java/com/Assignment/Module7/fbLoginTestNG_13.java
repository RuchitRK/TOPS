package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fbLoginTestNG_13 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void loginTest() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("test13r@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Test13@123");
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
    }
    @AfterMethod
    public void browserQuit() {
    	driver.quit(); 
    }
}