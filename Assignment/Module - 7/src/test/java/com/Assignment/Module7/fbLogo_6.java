package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class fbLogo_6 {
    public static void main(String[] args) throws InterruptedException {
        
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        WebElement fbLogo = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
        System.out.println("Logo Image Source: " + fbLogo.getAttribute("src"));
        Thread.sleep(3000);
        driver.quit();
    }
}