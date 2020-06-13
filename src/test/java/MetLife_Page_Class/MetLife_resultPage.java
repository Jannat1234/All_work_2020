package MetLife_Page_Class;

import Reusable_class.Abstract_class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;

public class MetLife_resultPage extends Abstract_class {

    @Test
    public void MetLife_Result() throws InterruptedException {

        //using arrayList to define array data
        //array list for zip code
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

        for (int i = 0; i<zipCode.size(); i++) {

            logger.log(LogStatus.INFO,"Navigate to Metlife home page");
            driver.navigate().to("http://www.Metlife.com");
            Thread.sleep(2000);
            //verify title
            MetLife_BaseClass.metLife_homepage().verifyTitle();
            //click on solution tab
            MetLife_BaseClass.metLife_homepage().solutionTab();
            //click take along dental
            MetLife_BaseClass.metLife_homepage().TakeAlongDental();
            //verify title
            MetLife_BaseClass.metLife_enrollPage().verifyTitle();
            //click enroll
            MetLife_BaseClass.metLife_enrollPage().Enroll();
            //define arrayList for new window
            ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

            //switch to new window
            driver.switchTo().window(newTab.get(1));

            //wait few seconds
            Thread.sleep(2000);
            //enter zipcode
            MetLife_BaseClass.metLife_zipcodePage().zipCode(zipCode.get(i));
            //click go button
            MetLife_BaseClass.metLife_zipcodePage().submit();
            Thread.sleep(3000);
            //select ppo type
            MetLife_BaseClass.metLife_ppOpage().PPOType("//*[@class='" + dentalProgram.get(i) + "']");
            //click on enroll
            MetLife_BaseClass.metLife_ppOpage().EnrollProgram();
            //enter referral code
            MetLife_BaseClass.metLife_ppOpage().referralCode(referralCode.get(i));
            //go button
            MetLife_BaseClass.metLife_ppOpage().Gobutton();
            //capture message
            MetLife_BaseClass.metLife_ppOpage().errorMessage();
            //enroll without code
            MetLife_BaseClass.metLife_ppOpage().Enrollwithoutreferralcode();
            Thread.sleep(3000);
            //Capture the PPO title using try and catch
            try {
                WebElement ppoTittle = driver.findElement(By.xpath("//*[@class='col-sm-8']"));
                if (ppoTittle.getText().contains(dentalProgram.get(i))) {
                    System.out.println("PPO Title matches with expected PPO " + ppoTittle.getText());
                } else {
                    System.out.println("PPO Title does not match " + ppoTittle.getText());
                }//end of if and else
            }catch (Exception e) {
                System.out.println("unable to locate PPO Title " + e);
            }//end of try and catch

            Thread.sleep(2000);

          driver.close();

          //switch to original tab
            driver.switchTo().window(newTab.get(0));




        }//end of for loop

    }//end of test

}//end of java class
