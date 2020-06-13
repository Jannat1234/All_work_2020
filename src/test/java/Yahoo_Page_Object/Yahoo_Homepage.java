package Yahoo_Page_Object;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Homepage extends Abstract_class {


  ExtentTest locallogger;
//we need to create a constructor method that defines
    //driver and logger to be reuse localy to this page class
    //constructor inherits same name as your java class

    public Yahoo_Homepage(WebDriver driver){
        super ();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of constructor

    //method for searchfield
    public Yahoo_Homepage searchField(String userValue){
        Reusable_Library_logger.userKeys(driver,"//*[@id='header-search-input']",userValue,"search field",logger);
        //the driver that i used is returning you thr same
        //yahoo_homepage
        return new Yahoo_Homepage(driver);

    }//end of search field
    //method for searchIcon
    public Yahoo_Homepage searchIcon(){
        Reusable_Library_logger.click(driver,"//*[@id='header-desktop-search-button']","search icon",logger);
        return new Yahoo_Homepage(driver);

    }//end of search Icon method



}//end of class
