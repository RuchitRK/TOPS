package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class hyperlink_9 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qavbox.github.io/demo/webtable/");
        driver.manage().window().maximize();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total hyperlinks found on the page: " + links.size());
        Thread.sleep(5000);
        driver.quit();
    }
}
