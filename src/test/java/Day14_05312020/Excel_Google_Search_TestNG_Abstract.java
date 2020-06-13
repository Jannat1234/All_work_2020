package Day14_05312020;

import Reusable_class.Abstract_class;
import Reusable_class.Reusable_Library;
import Reusable_class.Reusable_Library_logger;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Excel_Google_Search_TestNG_Abstract extends Abstract_class {

    //readable workbook
    Workbook readableFile;

    //readable sheet
    Sheet readableSheet;

    //writable workbook
    WritableWorkbook writableFile;

    //writable sheet
    WritableSheet wSheet;
    @Test
            public void Google() throws IOException, InterruptedException, BiffException, WriteException {
     //Step 1:
     //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src//main//resources//Google_Search.xls"));

        //step 2:
        //locate the readable worksheet by index
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3
        //we need to create a writable workbook to mimic readable file because we shouldn't be writing on readable file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src//main//resources//Google_Search_Result.xls"),readableFile);

        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);

        //get the total rows that are not empty
        int rows = writableSheet.getRows();



        //define the for loop
        for (int i=1; i < rows; i++) {

            //step 4
            //store the cars column values as String variable
            //columns are always hard coded whereas the rows are dynamic based on your i
            String cars = writableSheet.getCell(0,i).getContents();

            //navigate to google page
            driver.navigate().to("http://www.google.com");

            //timeout
            Thread.sleep(2500);

            //reusable library to enter car values on search field
            Reusable_Library_logger.userKeys(driver,"//*[@name='q']",cars,"search Field" ,logger);

            //reusable library to click on google search
            Reusable_Library_logger.submit(driver,"//*[@name='btnK']","Google search",logger);



            //timeout
            Thread.sleep(2500);

            String result = Reusable_Library_logger.captureText(driver,"//*[@id='result-stats']","search Result",logger);
            String [] resultArray = result.split(" ");
            System.out.println("My search result is " + resultArray[1]);
            logger.log(LogStatus.INFO,"My search result is " + resultArray[1]);

            //step 5
            //write the search number result back to writable sheet
            Label label = new Label(1,i, resultArray[1]);
            //adding back to writable cell
            writableSheet.addCell(label);




        }//end of loop

        //outside of loop
        writableFile.write();
        writableFile.close();
        readableFile.close();

        //quit the driver
        //driver.quit();




    }//end of test


}//end of java
