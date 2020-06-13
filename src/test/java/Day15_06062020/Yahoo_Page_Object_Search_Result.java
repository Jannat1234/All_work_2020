package Day15_06062020;

import Reusable_class.Abstract_class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class Yahoo_Page_Object_Search_Result extends Abstract_class {

    @Test
    public void Yahoo_search_Result() throws InterruptedException {

        logger.log(LogStatus.INFO,"Navigating to yahoo Home Page");
        driver.navigate().to("http://www.yahoo.com");
        Thread.sleep(2500);
        Yahoo_Base_Class.yahoo_homepage().searchField("cars");
        //click on search icon
        Yahoo_Base_Class.yahoo_homepage().searchIcon();
        Thread.sleep(2000);
        //scroll to the bottom of the page
        Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
        //getting search number
        Yahoo_Base_Class.yahoo_search_result_page().searchNumber();

    }//end of test method





}
