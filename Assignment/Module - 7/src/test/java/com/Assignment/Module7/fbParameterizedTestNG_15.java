package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fbParameterizedTestNG_15 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"user151@gmail.com", "pass123"},
            {"user152@gmail.com", "pass456"},
            {"user153@gmail.com", "pass789"}
        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException {
        System.out.println("Testing with: " + username + " / " + password);
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void browserQuit() {
    	driver.quit();     
    }
}
