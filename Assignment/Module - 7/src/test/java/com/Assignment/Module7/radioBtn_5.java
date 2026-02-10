package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class radioBtn_5 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        List<WebElement> radioBtns = driver.findElements(By.name("radiooptions"));
        System.out.println("Total radio buttons found: " + radioBtns.size());
        for (int i = 0; i < radioBtns.size(); i++) {
            WebElement radio = radioBtns.get(i);
            if (!radio.isSelected()) {
                radio.click();
                System.out.println("Selected radio button: " + radio.getAttribute("value"));
                Thread.sleep(2000);
            }
        }
        driver.quit();
    }
}
