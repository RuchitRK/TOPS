package com.shopezusa.reports;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsClass {
    public static ExtentReports getReport(){
    	System.out.println("ReportsClass Executed");
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/result.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}

