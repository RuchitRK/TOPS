package com.shopezusa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopezusa.base.BaseClass;
import com.shopezusa.pages.ProductPage;

public class AddToCartTest extends BaseClass{
	@Test(priority = 3)
    public void verifyAddToCart() throws InterruptedException {
		test = extent.createTest("Step 3: Verify Add To Cart - Backpack");
        ProductPage productPage = new ProductPage(driver);
        test.info("Attempting to search and add Backpack to cart");
        productPage.AddToCart();
        test.pass("Successfully clicked Add to Cart button");
        int count = productPage.CartCount();
        System.out.println("Items in cart: " + count);
        Assert.assertTrue(count > 0);
        test.pass("Cart Count Increased from 0 to: " +count);
    }
}
