package MetLife_Page_Class;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class MetLife_PPOpage extends Abstract_class {

    ExtentTest locallogger;
//we need to create a constructor method that defines
    //driver and logger to be reuse localy to this page class
    //constructor inherits same name as your java class

    public MetLife_PPOpage(WebDriver driver){
        super ();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of constructor

//method of PPO type
    public MetLife_PPOpage PPOType(String PPO){
     Reusable_Library_logger.click(driver,PPO,"PPO type",logger);
        return new MetLife_PPOpage(driver);
    }//end of ppo type

//method to click enroll
    public MetLife_PPOpage EnrollProgram(){
        Reusable_Library_logger.click(driver,"//*[@id='topenrolltab']","Enroll program",logger);
        return new MetLife_PPOpage(driver);
    }//end of enroll


    //method for to enter referral code
    public MetLife_PPOpage referralCode(String referralCode){
        Reusable_Library_logger.userKeys(driver,"//*[@id='txtBxPromocode']",referralCode,"referral code",logger);
        return new MetLife_PPOpage(driver);
    }//end of referral code

    //method to go button
    public MetLife_PPOpage Gobutton(){
        Reusable_Library_logger.click(driver,"//*[@name='btnEnroll']","Go button",logger);
        return new MetLife_PPOpage(driver);
    }//end of go button

    //Method to capture message
    public MetLife_PPOpage errorMessage(){
        Reusable_Library_logger.captureText(driver,"//*[@id='lblRefCodeError']","error Message",logger);
        return new MetLife_PPOpage(driver);
    }//end of capture message

    //method to enroll without referral code
    public MetLife_PPOpage Enrollwithoutreferralcode(){
        Reusable_Library_logger.click(driver,"//*[@id='withoutrefcode']","without referral code",logger);
        return new MetLife_PPOpage(driver);
    }//end of enroll without code




}//end of java class
