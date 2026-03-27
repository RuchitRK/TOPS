package com.Assignment.Module9;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorRealDeviceTest_7 {

	AndroidDriver driver;
    WebDriverWait wait;

    @SuppressWarnings("deprecation")
	@BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("61c2a43f"); 
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.setNoReset(true); 

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testCalculatorOperations() throws InterruptedException {
        System.out.println("Calculator launched! Starting math operations...");
        String pkg = "com.google.android.calculator:id/";
        
        WebElement btn8 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id(pkg + "digit_8")));
        WebElement btn2 = driver.findElement(AppiumBy.id(pkg + "digit_2"));
        
        WebElement btnAdd = driver.findElement(AppiumBy.accessibilityId("plus"));
        WebElement btnSub = driver.findElement(AppiumBy.accessibilityId("minus"));
        WebElement btnMul = driver.findElement(AppiumBy.accessibilityId("multiply"));
        WebElement btnDiv = driver.findElement(AppiumBy.accessibilityId("divide"));
        
        WebElement btnEquals = driver.findElement(AppiumBy.accessibilityId("equals"));
        WebElement resultDisplay = driver.findElement(AppiumBy.id(pkg + "result_final"));
        WebElement btnClear = driver.findElement(AppiumBy.accessibilityId("clear"));
        btn8.click();
        btnAdd.click();
        btn2.click();
        btnEquals.click();
        Assert.assertEquals(resultDisplay.getText(), "10", "Addition failed!");
        System.out.println("Addition (8+2) Passed: " + resultDisplay.getText());
        btnClear.click();
        btn8.click();
        btnSub.click();
        btn2.click();
        btnEquals.click();
        Assert.assertEquals(resultDisplay.getText(), "6", "Subtraction failed!");
        System.out.println("Subtraction (8-2) Passed: " + resultDisplay.getText());
        btnClear.click();
        btn8.click();
        btnMul.click();
        btn2.click();
        btnEquals.click();
        Assert.assertEquals(resultDisplay.getText(), "16", "Multiplication failed!");
        System.out.println("Multiplication (8*2) Passed: " + resultDisplay.getText());
        btnClear.click();
        btn8.click();
        btnDiv.click();
        btn2.click();
        btnEquals.click();
        Assert.assertEquals(resultDisplay.getText(), "4", "Division failed!");
        System.out.println("Division (8/2) Passed: " + resultDisplay.getText());
        
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
