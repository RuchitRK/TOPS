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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LongPressRealDeviceTest_5 {

    AndroidDriver driver;
    WebDriverWait wait;

    @SuppressWarnings("deprecation")
	@BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("61c2a43f");
        options.setDeviceName("Redmi Note 7 Pro");
        options.setApp("C:\\RuchitRK\\Redmi Note 7 Pro\\DEBUG_APPIUM_APK\\ApiDemos-debug.apk");
        options.autoGrantPermissions();

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testLongPressGesture() {
        System.out.println("App launched on Real Device. Navigating menus...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Views"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Expandable Lists"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("1. Custom Adapter"))).click();
        WebElement peopleNames = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='People Names']")
        ));
        System.out.println("Performing Long Press:");
        
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) peopleNames).getId(),
                "duration", 2000 
        ));
        WebElement sampleMenuPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']")
        ));
        Assert.assertTrue(sampleMenuPopup.isDisplayed(), "The long press failed to open the menu.");
        System.out.println("Long Press successful. The hidden menu appeared.");
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}