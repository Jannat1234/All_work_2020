package Day15_06062020;


import Reusable_class.Abstract_class;
import Reusable_class.Abstract_class_parameter;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class List_Boolean_TestNG_Abstract_cross extends Abstract_class_parameter {





    @Test
    public void yahoo_verification() throws InterruptedException {
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

        }//end of test method





}//end of java class
