package com.metr.listeners;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.metr.base.BaseDriver;



public class ListenersClass extends BaseDriver implements ITestListener
{

    ExtentReports report;
    ExtentSparkReporter spark;
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) 
    {
        String name = result.getMethod().getMethodName();
        Reporter.log(name+" is executing",true);
        test= report.createTest(name);
         
        
    }

    @Override
    public void onTestSuccess(ITestResult result) 
    {
        String name = result.getMethod().getMethodName();
        test.log(Status.PASS, name+ " is executed successfully");
        Reporter.log(name+" is executed successfully",true);
    }

    @Override
    public void onTestFailure(ITestResult result) 
    {
        String name = result.getMethod().getMethodName();
        test.log(Status.FAIL, name+"is failed");
        TakesScreenshot ts = (TakesScreenshot)driver;
        String screenshot = ts.getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(screenshot);
         
        
    }

    @Override
    public void onTestSkipped(ITestResult result) 
    {
        String name = result.getMethod().getMethodName();
        test.log(Status.SKIP, name+" is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
    {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) 
    {
        //create spark reporter
        try {
            spark = new ExtentSparkReporter(".\\extendrepots\\metRReports.html");
        } catch (EncryptedDocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //configure the spark reporter
        spark.config().setDocumentTitle("Metapercept Report");
        spark.config().setReportName("kajal");
        spark.config().setTheme(Theme.DARK);
        //create the extent report
        report = new ExtentReports();
        //configure extent report
        report.setSystemInfo("Os", "Window-11");
        report.setSystemInfo("Browser", "Chrome-100");
        
        //Attach the spark reporter to the extent report
        report.attachReporter(spark);
        
    }

    @Override
    public void onFinish(ITestContext context) 
    {
        report.flush();
    }
    
}