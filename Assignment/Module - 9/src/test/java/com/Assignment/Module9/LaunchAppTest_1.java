package com.Assignment.Module9;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LaunchAppTest_1 {

    AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RK_Device1");
        options.setApp("C:\\RuchitRK\\Redmi Note 7 Pro\\DEBUG_APPIUM_APK\\ApiDemos-debug.apk");
        @SuppressWarnings("deprecation")
		URL appiumServerUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(appiumServerUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testAppLaunch() {
        System.out.println("API Demos application launched successfully");
    }
}