package Day16_06072020;

import Reusable_class.Abstract_class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Yahoo_Page_Object_Search_Result extends Abstract_class {

    @Test
    public void Yahoo_search_Result() throws InterruptedException {

        //using arrayList to define array test data
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Lexus");
        cars.add("BMW");
        cars.add("Mercedes");

        //we are using reference name for page classes which is defined on yahoo base class

        for (int i= 0; i <cars.size(); i++) {


            logger.log(LogStatus.INFO, "Navigating to yahoo Home Page");
            driver.navigate().to("http://www.yahoo.com");
            Thread.sleep(2500);
            Yahoo_Base_Class.yahoo_homepage().searchField(cars.get(i));
            //click on search icon
            Yahoo_Base_Class.yahoo_homepage().searchIcon();
            Thread.sleep(2000);
            //scroll to the bottom of the page
            Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
            //getting search number
            Yahoo_Base_Class.yahoo_search_result_page().searchNumber();
        }//end of for loop
    }//end of test method





}
