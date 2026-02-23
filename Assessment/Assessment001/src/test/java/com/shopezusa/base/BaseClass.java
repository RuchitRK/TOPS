package com.shopezusa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.shopezusa.reports.ReportsClass;

public class BaseClass {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
	public void setup() {
		System.out.println("Excecuitng BaseClass.java and setting up driver");
		extent = ReportsClass.getReport();
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.shopezusa.com/");	
	}
	@AfterSuite
	public void quitBrowser() {
		driver.quit();
		extent.flush();
	}
}
