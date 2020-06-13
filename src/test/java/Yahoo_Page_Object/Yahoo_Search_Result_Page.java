package Yahoo_Page_Object;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Search_Result_Page extends Abstract_class {

    ExtentTest logger;
    public Yahoo_Search_Result_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger= super.logger;
    }//end of constructor

    public Yahoo_Search_Result_Page scrollToBottom(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        logger.log(LogStatus.INFO,"Scrolling to the bottom of yahoo search result page");
        jse.executeScript("scroll(0,10000);");
        return new Yahoo_Search_Result_Page(driver);
    }//end of scrolling method

    //method to capture the search number
    public Yahoo_Search_Result_Page searchNumber(){

        String searchResult = Reusable_Library_logger.captureText(driver,"//*[@class='compPagination']","Search Result",logger);
        String [] searchNumber = searchResult.split("Next");
        logger.log(LogStatus.INFO,"My Search number is " + searchNumber[1]);
        return new Yahoo_Search_Result_Page(driver);

    }//end of search number method





}
