package MetLife_Page_Class;

import Reusable_class.Abstract_class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_BaseClass extends Abstract_class {


    public MetLife_BaseClass(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }//end of constructor

    //object for metLife home page
    public static MetLife_Homepage metLife_homepage() {
        MetLife_Homepage metLife_homepage = new MetLife_Homepage(driver);
        return metLife_homepage;
    }//end of object

// object for metlife enroll page
     public static MetLife_EnrollPage metLife_enrollPage(){
        MetLife_EnrollPage metLife_enrollPage = new MetLife_EnrollPage(driver);
        return metLife_enrollPage;
     }//end of object for metlife enroll page

    //object for metlife zipcode page
    public static MetLife_zipcodePage metLife_zipcodePage(){
        MetLife_zipcodePage metLife_zipcodePage = new MetLife_zipcodePage(driver);
        return metLife_zipcodePage;
    }//end of object for metlife zipcode page

    //object for metlife PPO page
    public static MetLife_PPOpage metLife_ppOpage(){
        MetLife_PPOpage metLife_ppOpage = new MetLife_PPOpage(driver);
        return metLife_ppOpage;
    }//end  of object for metlife ppo page













}//end of java class
