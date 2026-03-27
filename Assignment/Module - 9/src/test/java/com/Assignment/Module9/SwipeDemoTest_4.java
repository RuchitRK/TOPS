package com.Assignment.Module9;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SwipeDemoTest_4 {

    AndroidDriver driver;
    WebDriverWait wait;

    @SuppressWarnings("deprecation")
	@BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RK_Device1");
        options.setApp("C:\\RuchitRK\\Redmi Note 7 Pro\\DEBUG_APPIUM_APK\\General-Store.apk");  

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testSwipeMenu() throws InterruptedException {
        System.out.println("Logging in:");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField"))).sendKeys("Ruchit RK");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        WebElement firstProductImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.androidsample.generalstore:id/productImage")
        ));
        System.out.println("Product menu loaded:");
        System.out.println("Performing swipe gesture...");
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) firstProductImage).getId(),
                "direction", "up",
                "percent", 0.75
        ));
        System.out.println("Swipe completed");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}