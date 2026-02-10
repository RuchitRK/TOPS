package com.Assignment.Module7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class linkText_1 {
    public static void main(String[] args) throws InterruptedException {
        
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.linkText("REGISTER")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("SUPPO")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
