package Day14_05312020;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library;
import Reusable_class.Reusable_Library_logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionItem_4_Metlife_TestNG_Abstract extends Abstract_class {




      @Test
       public void Met () throws InterruptedException {

          //for (int i = 0; i< 3 ; i++) {
        //arrayList for zip code
          ArrayList<String> zipCode = new ArrayList<>();
          zipCode.add("11218");
          zipCode.add("11219");
          zipCode.add("11214");


        //arrayList for referralCode
        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("1122");
        referralCode.add("5533");
        referralCode.add("9090");


        //arrayList for dentalProgram
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        for (int i = 0; i< 3 ; i++) {


            //navigate to metlife website
            driver.navigate().to("http://www.metlife.com");
             //wait few seconds
            Thread.sleep(2000);


            //get Title
            Reusable_Library_logger.verifyTitle(driver,"Insurance & Employee Benefit | Metlife ");


            //click on Solutions tab using try and catch
            Reusable_Library_logger.click(driver,"//*[@class='header__navigation-container-menu-item']","Tab",logger);

            //wait few seconds
            Thread.sleep(2000);

            //click on Metlife take along dental
            Reusable_Library_logger.click(driver,"//a[text()='MetLife TakeAlong Dental']","Take along dental",logger);

            Thread.sleep(2000);

            //verify title of the page
            Reusable_Library_logger.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife ");



            //click on Enroll now using try and catch
            Reusable_Library_logger.click(driver,"//*[@class='btn-brand-2nd table']","CLick on Enroll",logger);

            //wait few seconds
            Thread.sleep(2000);

            //define arrayList for new window
            ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

            //switch to new window
           driver.switchTo().window(newTab.get(1));

            //wait few seconds
            Thread.sleep(2000);

            //now enter zip code using try and catch
            Reusable_Library_logger.userTypeAndHitEnter(driver,"//*[@class='form-control']",zipCode.get(i),"Enter Zip",logger);

            //now submit zip
            Reusable_Library_logger.click(driver,"//*[@id='txtZipCodetxt']","submit zip",logger);

            //choose ppo type
            Reusable_Library_logger.click(driver,"//*[@class='" + dentalProgram.get(i) + "']","Choose ppo",logger);

            //wait few sec
            Thread.sleep(2000);

            //click on Enroll in program using try and catch
            Reusable_Library_logger.click(driver,"//*[@id='topenrolltab']","Click on Enroll",logger);

            //wait few sec
            Thread.sleep(2000);

            // now enter referral code
            Reusable_Library_logger.userTypeAndHitEnter(driver,"//*[@id='txtBxPromocode']",referralCode.get(i),"Referral code",logger);

            //wait few sec
            Thread.sleep(2000);

            //click on GO button
            Reusable_Library_logger.click(driver,"//*[@name='btnEnroll']","Click on Go",logger);

            //wait few sec
            Thread.sleep(2000);

            // capture red error message
            Reusable_Library_logger.captureText(driver,"//*[@id='lblRefCodeError']","Red error",logger);


            //wait few sec
            Thread.sleep(2000);

            //Enroll without referral code
            Reusable_Library_logger.click(driver,"//*[@id='withoutrefcode']","referral Code",logger);

            //wait few sec
            Thread.sleep(2000);

            //Capture the PPO title using try and catch
            Reusable_Library_logger.captureText(driver,"//*[@class='col-sm-8']","PPO title",logger);


            //wait few sec
            Thread.sleep(2000);

            //close current tab
            driver.close();

            //wait few sec
            Thread.sleep(2000);

            //switch to your default tab
            driver.switchTo().window(newTab.get(0));

            //wait few sec
            Thread.sleep(2000);




        }//end of for loop

        //quit browser
        //driver.quit();

    }//end of test


}//end of java class
