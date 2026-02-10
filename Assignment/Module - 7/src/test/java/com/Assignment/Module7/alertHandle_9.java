package com.Assignment.Module7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class alertHandle_9 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK ')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'alert box:')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        simpleAlert.accept();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'confirm box')]")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Text: " + confirmAlert.getText());
        wait.until(ExpectedConditions.alertIsPresent());
        confirmAlert.dismiss(); 
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'prompt box')]")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hello Assignment"); 
        Thread.sleep(3000);
        promptAlert.accept();
        Thread.sleep(2000);
        driver.quit();
    }
}
