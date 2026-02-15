package com.Assignment.Module8;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class dataDrivenLogin_1 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/SignIn.html");
    }
    @Test(dataProvider = "getExcelData")
    public void loginTest(String username, String password) throws InterruptedException {
        System.out.println("Testing with: " + username + " | " + password);
        // Locators based on the provided URL
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        WebElement passField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginBtn = driver.findElement(By.id("enterbtn"));
        emailField.sendKeys(username);
        passField.sendKeys(password);
        loginBtn.click();  
        Thread.sleep(2000);
        try {
            WebElement errorMsg = driver.findElement(By.id("errormsg"));
            if (errorMsg.isDisplayed()) {
                System.out.println("Invalid Credentials");
            }
        } catch (Exception e) {
            System.out.println("Login SUCCESSFUL");
        }
    }
    @DataProvider(name = "getExcelData")
    public Object[][] getData() throws IOException {
        String filePath = "src/test/resources/LoginData.xlsx"; 
        FileInputStream fis = new FileInputStream(filePath);   
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount - 1][colCount];
        DataFormatter formatter = new DataFormatter();
        for (int i = 0; i < rowCount - 1; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        workbook.close();
        fis.close();
        return data;
    }
    @AfterMethod
    public void shutDown() {
        driver.quit();
    }
    @AfterTest
    public void syso() {
    	System.out.println("DONE");
	}
}