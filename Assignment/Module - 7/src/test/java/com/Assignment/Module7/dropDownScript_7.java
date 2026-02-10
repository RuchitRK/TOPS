package com.Assignment.Module7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class dropDownScript_7 {
    public static void main(String[] args) throws InterruptedException { 
    	WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        WebElement skillsDropdown = driver.findElement(By.id("Skills"));
        Select select = new Select(skillsDropdown);
        System.out.println("All Available Skills dropdown: ");
        List<WebElement> allOptions = select.getOptions();
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
