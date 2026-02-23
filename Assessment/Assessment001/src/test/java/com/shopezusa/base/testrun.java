package com.shopezusa.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testrun {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.shopezusa.com/");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header-sticky\"]/div/header-inner/div[1]/div[3]/div[2]/a")));
		WebElement loginIcon = driver.findElement(By.xpath("//*[@id=\"header-sticky\"]/div/header-inner/div[1]/div[3]/div[2]/a"));
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		Action a1 = actions.moveToElement(loginIcon).keyDown(Keys.LEFT_CONTROL).click().keyUp(Keys.LEFT_CONTROL).build();
		a1.perform();
		Thread.sleep(5000);
		loginIcon.click();
		Thread.sleep(5000);
	}

}
