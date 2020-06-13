package MetLife_Page_Class;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_zipcodePage extends Abstract_class {

    ExtentTest localLogger;

    public MetLife_zipcodePage(WebDriver driver){
        super ();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of constructor

    // method for zip Code
    public MetLife_zipcodePage zipCode(String uservalues) {
        Reusable_Library_logger.userKeys(driver,"//*[@class='form-control']",uservalues,"zip code",logger);
        return new MetLife_zipcodePage(driver);
    }//end of zip code

    //method for submit
    public MetLife_zipcodePage submit(){
        Reusable_Library_logger.submit(driver,"//*[@id='txtZipCodetxt']","submit",logger);
        return new MetLife_zipcodePage(driver);
    }//end of submit



}//end of java class
