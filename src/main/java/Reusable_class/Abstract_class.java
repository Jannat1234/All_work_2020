package Reusable_class;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_class {


 //you need set the global variable as public static in order
    //to be used on your @test classes

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    //define before suite to set a static driver
    @BeforeSuite
    public void  defineDriver () throws IOException, InterruptedException {
        driver= Reusable_Library_logger.setDriver();
        //define the report path as usual
        reports = new ExtentReports("src//main//java//html_reports//TestReport.html",true);
    }//end of before suite

    //before method will be used to capture a unique @test name that you gave
    //on your test class
    @BeforeMethod
    public void getMethodName(Method methodname) {
        //start the logger here to capture the method name
        logger = reports.startTest(methodname.getName());
    }//end of before method

    //after method will end each test
    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//end of after method

    //after suite will quit and flushh to your report
    @AfterSuite
    public void closeInfo(){
       //driver.quit();
       reports.flush();
    }//end of after suite


}//end of java class
