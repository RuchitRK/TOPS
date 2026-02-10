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

public class gmail_4 {
    public static void main(String[] args) throws InterruptedException {    
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://accounts.google.com/signup");
        driver.manage().window().maximize();
        driver.findElement(By.id("firstName")).sendKeys("AssignmentFirstName");
        driver.findElement(By.id("lastName")).sendKeys("LastName1");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        WebElement month = driver.findElement(By.id("month"));
        month.click();
        Thread.sleep(2000);
        WebElement monthName = driver.findElement(By.xpath("//span[text()='November']"));
        Actions actions=new Actions(driver);
        Action a1 = actions.moveToElement(monthName).keyDown(monthName, Keys.ENTER).build();
        a1.perform();
        Thread.sleep(2000);
        driver.findElement(By.id("day")).sendKeys("11");
        driver.findElement(By.id("year")).sendKeys("1999");
        WebElement gender = driver.findElement(By.id("gender"));
        gender.click();
        WebElement selectGender = driver.findElement(By.xpath("//span[text()='Male']"));
        Action a2 = actions.moveToElement(selectGender).keyDown(selectGender, Keys.ENTER).build();
        a2.perform();
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='custom']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("Username")).sendKeys("test202677004488");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("Passwd")).sendKeys("StrongPass123!");
        driver.findElement(By.name("PasswdAgain")).sendKeys("StrongPass123!");
        //driver.findElement(By.xpath("//span[text()='Next']")).click(); //comment because it will submit
        Thread.sleep(5000);
        driver.quit();
    }
}
