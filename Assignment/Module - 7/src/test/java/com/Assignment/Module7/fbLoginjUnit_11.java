package com.Assignment.Module7;


import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fbLoginjUnit_11 {   
    WebDriver driver;
    @Before
    public void setUp() {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void testLogin() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("test11@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("test11_123");
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
    }
    @After
    public void browserQuit() {
    	driver.quit();
    }
}