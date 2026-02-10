package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class dropDown_2 {
    public static void main(String[] args) throws InterruptedException {
        
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://output.jsbin.com/osebed/2");
		Thread.sleep(1000);
		WebElement multiDD=driver.findElement(By.id("fruits"));
		Select s1=new Select(multiDD);
		Thread.sleep(1000);
		s1.selectByIndex(0);
		Thread.sleep(1000);
		s1.selectByValue("apple");
		Thread.sleep(1000);
		s1.selectByVisibleText("Orange");
		Thread.sleep(1000);
		s1.selectByContainsVisibleText("Grape");
        Thread.sleep(3000);
        driver.quit();
    }
}