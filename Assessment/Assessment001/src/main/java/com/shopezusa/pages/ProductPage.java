package com.shopezusa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.shopezusa.utilities.WaitUtilities;

public class ProductPage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private By searchBox = By.name("q");
    private By productLink = By.xpath("//a[text()='Connect Laptop Backpack']");
    private By addToCartBtn = By.name("add");
    private By cartCountDrawer = By.cssSelector(".cart-count.cart-count-drawer");
    public ProductPage(WebDriver driver) {
    	System.out.println("Product Page executed");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void AddToCart() throws InterruptedException {
    	WaitUtilities.waitForClickable(driver, (searchBox));
    	driver.findElement(searchBox).click();
    	Thread.sleep(1500);
        driver.findElement(searchBox).sendKeys("Connect Laptop Backpack");
        WaitUtilities.waitForClickable(driver, (productLink));
        driver.findElement(productLink).click();
        WaitUtilities.waitForClickable(driver, (addToCartBtn));
        driver.findElement(addToCartBtn).click();
    }
    public int CartCount() {
        WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartCountDrawer));
        String rawText = countElement.getText();
        String numOnly = rawText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numOnly);
    }
}



