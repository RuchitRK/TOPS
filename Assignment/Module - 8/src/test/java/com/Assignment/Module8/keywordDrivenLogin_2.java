package com.Assignment.Module8;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.time.Duration;

public class keywordDrivenLogin_2 {  
    static WebDriver driver;
    public static void main(String[] args) throws Exception {
        String path = "src/test/resources/LoginData.xlsx"; 
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet2");
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowCount; i++) {
            String keyword = sheet.getRow(i).getCell(0).getStringCellValue();
            System.out.println("Action: " + keyword);
            switch (keyword) {
                case "open_browser":
                	WebDriverManager.edgedriver().setup();
            		driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                    
                case "enter_url":
                    driver.get("https://demo.automationtesting.in/SignIn.html");
                    Thread.sleep(2000);
                    break;
                    
                case "enter_username":
                    driver.findElement(By.xpath("//input[@placeholder='E mail']")).sendKeys("admin@gmail.com");
                    Thread.sleep(2000);
                    break;
                    
                case "enter_password":
                    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
                    Thread.sleep(2000);
                    break;
                    
                case "click_login":
                    driver.findElement(By.id("enterbtn")).click();
                    Thread.sleep(2000);
                    break;
                    
                case "close_browser":
                    driver.quit();
                    break;
                    
                default:
                    System.out.println("Invalid Keyword: " + keyword);
                    Thread.sleep(2000);
            }
        }
        workbook.close();
        fis.close();
        System.out.println("DONE");
    }
}