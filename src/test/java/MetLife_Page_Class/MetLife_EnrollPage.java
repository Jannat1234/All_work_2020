package MetLife_Page_Class;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_EnrollPage extends Abstract_class {

    ExtentTest localLogger;

    public MetLife_EnrollPage(WebDriver driver){
        super ();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of constructor

    public MetLife_EnrollPage verifyTitle(){
        Reusable_Library_logger.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife");
        return new MetLife_EnrollPage(driver);
    }//end of title

    public MetLife_EnrollPage Enroll(){
        Reusable_Library_logger.click(driver,"//*[@class='btn-brand-2nd table']","Click on Enroll",logger);
        return new MetLife_EnrollPage(driver);
    }//end of click enroll



}//end of class
