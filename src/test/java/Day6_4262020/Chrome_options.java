package Day6_4262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Chrome_options {

    public static void main(String[] args) throws InterruptedException {

    //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
     //set some pre conditions using chromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for thr driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mlcalc.com
        driver.navigate().to("http://www.mlcalc.com");
        Thread.sleep(4000);
        //i want to capture the title of that page
        System.out.println("my title is " + driver.getTitle());
        // store your actual little on a variable and then compare with your expected
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("MORTGAGE CALCULATOR & LOAN CALCULATOR")){
            System.out.println("Title matches with expected");
        } else {
            System.out.println("Title doesnt match " + actualTitle);
        }//end of if else

         //if same locator used moe than once then store it as a WebElement variable to reuse it
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the field first
        pPrice.clear();
        //enter your new data
        pPrice.sendKeys("400000");

        //store your start month in WebElement varibale and call it on your select command
        WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        //call my select command and it only works when your dropdown locator is under select tag
        Select sMonthList = new Select(sMonth);
        //select the drop down value by visible text
        //sMonthList.selectByIndex(0);
        //sMonthList.selectByValue("1");
        sMonthList.selectByVisibleText("May");

        //whenever drop down is not under select tag then we must click on the dropdown and then
        //click on the value of the dropdown
        //lets verify some of the start year to make sure it's matching on the drop down
        String[] yearArray = new String[] {"2005","2015","2035"};
        for (int i =0; i <yearArray.length;i++) {

            driver.findElement(By.xpath("//*[@name='sy']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[text()='"+yearArray[i]+"']")).click();
        }

    }//end of main method




}//end of java class
