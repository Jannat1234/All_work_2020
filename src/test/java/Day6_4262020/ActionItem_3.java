package Day6_4262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionItem_3 {

    public static void main(String[] args) throws InterruptedException {

       //set the Chrome path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        //set some pre conditions using chromeOptions
        //basically maximize the browser and incognito(private browser/result wont be the history page) mood
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for thr driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);



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
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("WeightWatch is healthy")){
                System.out.println("Title matches with expected");
            } else {
                System.out.println("Title doesn't match " + actualTitle);
            }//end of if else
            Thread.sleep(2000);
         //find workshop
         driver.findElement(By.xpath("//*[@class='last leaf menu-link-find-a-workshop']")).click();
         Thread.sleep(2000);
         //enter zipcode
            driver.findElement(By.xpath("//*[@id='meetingSearch']")).sendKeys(zipCode[i]);
            Thread.sleep(2000);
            //now submit
            driver.findElement(By.xpath("//*[@class='btn spice-translated']")).submit();

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
