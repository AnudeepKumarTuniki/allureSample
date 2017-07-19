package main.java.anudeep.selenium;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;

public class Sample
{

    public ChromeDriver webDriver;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite
    public void testingBrowser(){

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
        extent=new ExtentReports("D://MyExtentReport.html",true);
        extent.loadConfig(new File("ExtentReportConfiguration/extent-config.xml"));
        test=extent.startTest(this.getClass().getSimpleName());
        test.assignAuthor("Anudeep Tuniki");
        test.assignCategory("Smoke Tetsing");
        webDriver=new ChromeDriver();
        test.log(LogStatus.PASS,"Browser is successfully launched");


    }

    @Test
    public void hellowWorldProgram(){

        webDriver.get("https://www.google.com");
        test.log(LogStatus.PASS,"The URL has been successfully launched");

    }

    @AfterSuite
    public void tearDown(){
        webDriver.quit();
        extent.flush();
        extent.close();

    }
}
