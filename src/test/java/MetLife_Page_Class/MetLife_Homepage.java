package MetLife_Page_Class;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class MetLife_Homepage extends Abstract_class {


    ExtentTest localLogger;

    public MetLife_Homepage(WebDriver driver){
        super ();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of constructor

 public MetLife_Homepage verifyTitle() {
     Reusable_Library_logger.verifyTitle(driver,"Insurance & Employee Benefit | Metlife");

     return new MetLife_Homepage(driver);

 }//end of verifyTitle

    public MetLife_Homepage solutionTab(){
        Reusable_Library_logger.Hover(driver,"//*[@class='header__navigation-container-menu-item']","Soultion Tab",logger);
    return new MetLife_Homepage(driver);

    }//end of solutionTab

    public MetLife_Homepage TakeAlongDental(){
        Reusable_Library_logger.click(driver,"//a[text()='MetLife TakeAlong Dental']","TakeAlong Dental",logger);
     return new MetLife_Homepage(driver);
    }// end of Take along



}//end of java class
