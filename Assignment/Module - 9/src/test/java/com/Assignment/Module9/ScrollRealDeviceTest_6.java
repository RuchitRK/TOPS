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

public class ScrollRealDeviceTest_6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @SuppressWarnings("deprecation")
	@BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("61c2a43f");
        options.setApp("C:\\RuchitRK\\Redmi Note 7 Pro\\DEBUG_APPIUM_APK\\ApiDemos-debug.apk");
        options.autoGrantPermissions();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testScrollThroughAllOptions() {
        System.out.println("App launched. Navigating to the Views menu:");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Views"))).click();
        WebElement listContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("android:id/list")
        ));
        System.out.println("Starting the scroll engine:");
        boolean canScrollMore;
        int scrollCount = 0;

        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) listContainer).getId(),
                    "direction", "down",
                    "percent", 1.0 
            ));
            
            scrollCount++;
            System.out.println("Scrolled down page " + scrollCount);
            
        } while (canScrollMore);

        System.out.println("Reached the absolute bottom of the list after " + scrollCount + " scrolls!");
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
