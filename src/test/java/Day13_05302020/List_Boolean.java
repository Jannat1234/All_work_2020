package Day13_05302020;


import Reusable_class.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean {

//declare the driver outside
    WebDriver driver;

  @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
      driver= Reusable_Library.setDriver();

  }//end of before method

    @Test
    public void yahoo_verification() throws InterruptedException {
      //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //3 to 4 sec
        Thread.sleep(3000);
        //i want to count all the links in yahoo homepage and print it
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //verify if linkCount returns you 12 links
        if (linkCount.size()==12){
            System.out.println("My yahoo home page link count matches and it is " + linkCount.size());
        }else {
            System.out.println("My yahoo home page link count doesn't matches and actual is " + linkCount.size());
        }//end of else

        //click on sign in link
        Reusable_Library.click(driver,"//*[@id='header-profile-menu']", "sign in");
        Thread.sleep(3000);
        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == true) {
            System.out.println("checkbox is selected by default");
        } else {
            System.out.println("Checkbox is not selected by default");
        }//end of if else


    }//end of test method

    @AfterSuite
    public void closeSession() {
      //driver.quit();
    }//end of after suite


}//end of java class
