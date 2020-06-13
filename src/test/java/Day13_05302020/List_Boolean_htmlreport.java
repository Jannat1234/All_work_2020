package Day13_05302020;


import Reusable_class.Reusable_Library;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean_htmlreport {

//declare the driver outside
    WebDriver driver;

    //define
    ExtentReports reports;

    //define
    ExtentTest logger;



  @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
      driver= Reusable_Library.setDriver();
      Thread.sleep(2000);
      //define the report path here as a before suite
      reports = new ExtentReports("src//main//java//html_reports//AutomationReport.html",true);

  }//end of before method

    @Test
    public void yahoo_verification() throws InterruptedException {
      //define and start the test
        logger = reports.startTest("yahoo verification");
        //navigate to yahoo home page
        logger.log(LogStatus.INFO,"navigate to yahoo home page");
      //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //3 to 4 sec
        Thread.sleep(3000);
        //i want to count all the links in yahoo homepage and print it
        logger.log(LogStatus.INFO,"Getting the List count for all links");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //verify if linkCount returns you 12 links
        if (linkCount.size()==12){
            System.out.println("My yahoo home page link count matches and it is " + linkCount.size());
            logger.log(LogStatus.PASS,"My yahoo home page link count matches and it is " + linkCount.size());
        }else {
            System.out.println("My yahoo home page link count doesn't matches and actual is " + linkCount.size());
            logger.log(LogStatus.FAIL,"My yahoo home page link count matches and it is " + linkCount.size());
        }//end of else

        //click on sign in link
        Reusable_Library_logger.click(driver,"//*[@id='header-profile-menu']", "sign in",logger);
        Thread.sleep(3000);
        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == true) {
            System.out.println("checkbox is selected by default");
            logger.log(LogStatus.PASS,"The check box is  selected by default");
        } else {
            System.out.println("Checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"The check box is not selected by default");
        }//end of if else

        reports.endTest(logger);

        }//end of test method



    @AfterSuite
    public void closeSession() {
      //driver.quit();
        //flushing = writing the logs(loggers) back to your automation report that you defines
        reports.flush();

    }//end of after suite


}//end of java class
