package com.Assignment.Module9;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class RealDeviceLaunchTest_2 {

    AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("61c2a43f");
        options.setDeviceName("Redmi Note 7 Pro");
        options.setApp("C:\\RuchitRK\\Redmi Note 7 Pro\\DEBUG_APPIUM_APK\\ApiDemos-debug.apk");
        options.autoGrantPermissions();
        @SuppressWarnings("deprecation")
		URL appiumServerUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(appiumServerUrl, options);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testRealDevice() {
        System.out.println("API Demos is running on a REAL physical phone");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
