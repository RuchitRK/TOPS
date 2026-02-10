package com.Assignment.Module7;

import org.junit.Assert;
import org.junit.Test;

public class jUnitAssert_10 {

    @Test
    public void testAllMethods() {
        Assert.assertEquals("Values should match", 10, 10);
        Assert.assertTrue("Condition should be true", 5 > 2);
        Assert.assertFalse("Condition should be false", 5 < 2);
        Assert.assertNull("Object should be null", null);
        Assert.assertNotNull("Object should not be null", "Java");
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        Assert.assertArrayEquals("Arrays should match", expected, actual);
        System.out.println("All Assert methods passed successfully");
    }
}