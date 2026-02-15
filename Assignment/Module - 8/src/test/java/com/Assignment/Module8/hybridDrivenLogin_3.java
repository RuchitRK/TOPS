package com.Assignment.Module8;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.time.Duration;

public class hybridDrivenLogin_3 {
    static WebDriver driver;
    public static void main(String[] args) throws Exception {
        String path = "src/test/resources/LoginData.xlsx";        
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet3");
        int rowCount = sheet.getPhysicalNumberOfRows();
        DataFormatter formatter = new DataFormatter();
        System.out.println("--- Starting Hybrid Test Execution ---");
        for (int i = 1; i < rowCount; i++) {
            String keyword = formatter.formatCellValue(sheet.getRow(i).getCell(0));
            String data = formatter.formatCellValue(sheet.getRow(i).getCell(1));
            System.out.println("Step " + (i+1) + ": " + keyword + " | Data: " + data);
            switch (keyword.toLowerCase().trim()) {
                case "open_browser":
                	WebDriverManager.edgedriver().setup();
            		driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "enter_url":
                    if(data != null && !data.equals("null")) {
                        driver.get(data);
                    }
                    break;

                case "enter_username":
                    driver.findElement(By.xpath("//input[@placeholder='E mail']")).sendKeys(data);
                    break;

                case "enter_password":
                    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(data);
                    break;

                case "click_login":
                    driver.findElement(By.id("enterbtn")).click();
                    break;

                case "click_logout":
                    System.out.println("Logout step skipped (No logout button on this page).");
                    break;

                case "close_browser":
                    driver.quit();
                    break;

                default:
                    System.out.println("Skipping row or Invalid Keyword: " + keyword);
                    break;
            }
        }      
        workbook.close();
        fis.close();
        System.out.println("DONE");
    }
}