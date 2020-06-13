package Day14_05312020;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library;
import Reusable_class.Reusable_Library_logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ActionItem_3_weightwatch_TestNG_Abstract extends Abstract_class {

   @Test
     public void weightWatch() throws InterruptedException {




      //create Dynamic Array
        String[] zipCode = new String[3];
        zipCode[0] = "11218";
        zipCode[1] = "11219";
        zipCode[2] = "11214";
        //create for loop
        for (int i = 0; i<zipCode.length;i++) {
            //navigate to WeightWatchers.com
            driver.navigate().to("https://www.weightwatchers.com");
            //wait 3 sec
            Thread.sleep(3000);
            //verify title
            Reusable_Library_logger.verifyTitle(driver,"WeightWatch is healthy");

            Thread.sleep(2000);
         //find workshop
            Reusable_Library_logger.click(driver,"//*[@data-e2e-name='find_a workshop']","Find workshop",logger);

         Thread.sleep(2000);
         //enter zipcode
            Reusable_Library_logger.userTypeAndHitEnter(driver,"//*[@id='meetingSearch']",zipCode[i],"Enter Zip",logger);

            Thread.sleep(2000);
            //now submit
            Reusable_Library_logger.submit(driver,"//*[@class='btn spice-translated']","Submit",logger);


            //using if condition to get specific link
            if (i==0){
                driver.findElements(By.xpath("//*[@class='location__name']")).get(0).click();
            }
           if (i==1){
               driver.findElements(By.xpath("//*[@class='location__name']")).get(1).click();
           }
          if (i==2){
              driver.findElements(By.xpath("//*[@class='location__name']")).get(2).click();
          }
          //capture the entire address
            String Address = driver.findElement(By.xpath("//*[@class='location']")).getText();
          System.out.println("Address for Weightwatchers is " + Address);

          //capture the entire table
            String EntireTable = driver.findElement(By.xpath("//*[@class='schedule-detailed']")).getText();
            System.out.println("Entire Time table for weightwatchers is " + EntireTable);



        }//end of for loop












    }// end of main method

}//end of java class
