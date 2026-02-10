package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class actionMouseKeyboard_8 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
        WebElement home=driver.findElement(By.linkText("Home"));
		WebElement flights=driver.findElement(By.linkText("Flights"));
		WebElement hotes=driver.findElement(By.linkText("Hotels"));
		Actions actions=new Actions(driver);
		Action a1=actions.moveToElement(home).build();
		a1.perform();
		Thread.sleep(2000);
		Action a2=actions.moveToElement(flights).build();
		a2.perform();
		Thread.sleep(2000);
		Action a3=actions.moveToElement(hotes).build();
		a3.perform();
		Thread.sleep(2000);
        System.out.println("Mouse Hover Event done");
        Thread.sleep(2000);
        driver.get("https://www.facebook.com/");
        WebElement emailField = driver.findElement(By.id("email"));
        actions.moveToElement(emailField).click().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).doubleClick().contextClick().perform();
        System.out.println("Keyboard events done");
        Thread.sleep(3000);
        driver.quit();
    }
}