package Day15_06062020;

import Reusable_class.Abstract_class;
import Reusable_class.Abstract_class_parameter;
import Reusable_class.Reusable_Library_logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Action6_Kayak_Driven_testNG_Abstract_cross extends Abstract_class_parameter {


    //readable workbook
    Workbook readableFile;

    //readable sheet
    Sheet readableSheet;

    //writable workbook
    WritableWorkbook writableFile;

    //writable sheet
    WritableSheet wSheet;



    @Test
    public void Kayak() throws InterruptedException, WriteException, IOException, BiffException {
        //Define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//resources//Kayak_search.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Kayak_search_result.xls"),readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);
      int row = wSheet.getRows();

      // for Loop
        for (int i= 1; i < 2; i++) {
            String airportName = wSheet.getCell(0,i).getContents();
            String startDate = wSheet.getCell(1,i).getContents();
            String startTime = wSheet.getCell(2,i).getContents();
            String endDate = wSheet.getCell(3,i).getContents();
            String endTime = wSheet.getCell(4,i).getContents();
            String vehicleSize = wSheet.getCell(5,i).getContents();
            String vehicleInfo = wSheet.getCell(6,i).getContents();


            //navigate to kayak home page
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);

            //click on search Field
            Reusable_Library_logger.click(driver,"//*[@data-placeholder='Enter an airport or city']","Search Filed",logger);
            Thread.sleep(2000);

            //enter airport
            Reusable_Library_logger.userKeys(driver,"//*[@name='pickup']",airportName,"Search Filed",logger);
            Thread.sleep(2000);

            //click on airport
            Reusable_Library_logger.MouseClick(driver,"//li[@tabindex='0']","clickAirport",logger);
            Thread.sleep(2000);

            //click on end date
            Reusable_Library_logger.clickByIndex(driver,"//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']",1,"end date",logger);
            Thread.sleep(2000);



            //enter end date
            Reusable_Library_logger.userTypeAndHitEnter(driver,"//*[contains(@id,'-dropoff-date-input')]",endDate,"endDate",logger);
            Thread.sleep(2000);



            //click somewhere outside to close the calendar screen
            Reusable_Library_logger.click(driver,"//*[@class='title dark']","clickOutside",logger);
            Thread.sleep(2000);



            //click on end time
            Reusable_Library_logger.clickByIndex(driver,"//*[@aria-haspopup='listbox']",2,"endTime",logger);


            //clicking on a endTime
            Reusable_Library_logger.clickByIndex(driver,"//li[@aria-label='"+endTime+"']",1,"End Time",logger);


            //click on start date calendar screen
            Reusable_Library_logger.clickByIndex(driver,"//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']",0,"startDate",logger);


            //enter a future start date like next month
            Reusable_Library_logger.userTypeAndHitEnter(driver,"//div[contains(@id,'pickup-date-input')]",startDate,"Start Date",logger);


            // click somewhere outside
            Reusable_Library_logger.click(driver,"//*[@class='title dark']","clickOutside",logger);


            //clicking on a start time
            Reusable_Library_logger.clickByIndex(driver,"//li[@aria-label='"+startTime+"']",0,"StartTime",logger);


            //click on Search
            Reusable_Library_logger.click(driver,"//*[@class='_h-2 _ivP _iv1']","Search",logger);

            Thread.sleep(2000);

            //click on checkbox to select size
            Reusable_Library_logger.clickByIndex(driver,"//div[contains(@id,'"+vehicleSize+"')]",1,"Size",logger);


            //click on second index for View Deal
            Reusable_Library_logger.clickByIndex(driver,"//*[text()='View Deal']",1,"viewDeal",logger);

            Thread.sleep(3000);

            //define arrayList for new window
           ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

            //switch to new window
           driver.switchTo().window(newTab.get(1));

            //vehicle info is to capture arrival and departure info
            String result = Reusable_Library_logger.captureText(driver,"//*[@class='search_filters'or @class='col-12 col-lg-8 col-xl-8 carresult']","captureText",logger);
            System.out.println("My message is " + result);


            //write the search number result back to writable sheet
            Label label = new Label(6,i, result);

            //adding back to writable cell
            wSheet.addCell(label);

            //close current tab;;
           driver.close();


            //switch to your default tab
            driver.switchTo().window(newTab.get(0));

            driver.manage().deleteAllCookies();

        }//end of loop
        writableFile.write();
        writableFile.close();
        readableFile.close();


    }//end of test




}//end of java class
