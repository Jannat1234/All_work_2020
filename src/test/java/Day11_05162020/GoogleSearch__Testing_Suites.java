package Day11_05162020;

import Reusable_class.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleSearch__Testing_Suites {

    //when using automation method your local driver
    //must be declared outside so i can call it
    //on all my annotation method
    WebDriver driver;

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();

    }//end of Before Method

    @AfterSuite
    public  void quitDriver () {
        driver.quit();
    }//end of Aftermethod

    String getURL;

    @Test(priority = 1)
    public  void searchIngoogle () throws InterruptedException {
        driver.navigate().to("http://www.google.com");
        //enter keyword car on mt search field
        Reusable_Library.userKeys(driver, "//*[@name='q']", "cars", "serach field");
        //click on submit
        Reusable_Library.submit(driver, "//*[@name='btnK']", "Google search button");
        Thread.sleep(2000);
        //capture the current url for search result page
        getURL = driver.getCurrentUrl();
        //end of test priority 1
        //when you ise dependsdnMethods in your @Test that means  your second test is dependant
        //on your first test if first test fails seconds test will be skipped
        //if all test has priorities they might or might not be dependant on each other
    }//end of priority 1
       //@Test(priority = 2)
        @Test (dependsOnMethods = "searchIngoogle")
        public void captureResult(){
            driver.navigate().to(getURL);
            //capture text and print out the search number
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Result");
            //split the text and print the number
            String[] arraySearch = searchResult.split(" ");
            System.out.println("My search number for car is " + arraySearch[1]);


    }//end of google test




    }//end of java class






