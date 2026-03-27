package com.Assignment.Module9;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GeneralStoreLoginTest_3 {

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
    public void testFillLoginForm() throws InterruptedException {
        System.out.println("App launched. Starting form fill:");
        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")
        ));
        countryDropdown.click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"
        )).click();
        System.out.println("Country Drop Down selected.");
        WebElement nameField = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        nameField.sendKeys("Ruchit RK");
        driver.hideKeyboard(); 
        System.out.println("Name entered.");
        Thread.sleep(5000);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}