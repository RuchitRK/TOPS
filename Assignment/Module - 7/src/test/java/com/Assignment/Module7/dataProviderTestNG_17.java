package com.Assignment.Module7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTestNG_17 {
    @DataProvider(name = "loginData")
    public Object[][] createData() {
        return new Object[][] {
            { "test171", "pass123" },
            { "test172",  "pass@456" },
            { "testAdmin173",  "pass@789" }
        };
    }
    @Test(dataProvider = "loginData")
    public void verifyLogin(String username, String password) {
        System.out.println("Test running with--> Username: " + username + " | Password: " + password);
    }
}