package Day10_05102020;

import Reusable_class.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Macys_Shopping {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException {

         //locate readable sheet
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Macys_Shopping.xls"));

        //locate readable sheet by index
        Sheet readableSheet = readableFile.getSheet(0);

        //open readable file through desktop command
        //Desktop.getDesktop().open(new File("src\\Resource\\Macys_Shopping.xls"));

        //now create writeable work sheet
        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src/Resource/Macys_Shopping_Results.xls"),readableFile);

        //create writeable sheet
        Sheet writableSheet = writeableFile.getSheet(0);

        //get the total rows that are not empty
        int rows = writableSheet.getRows();

        //define web driver
        WebDriver driver = Reusable_Library.setDriver();


        //define the for loop
        for (int i=1; i < rows; i++) {

        //store column as String Variable
        String email = writableSheet.getCell(0,i).getContents();
        String passWord = writableSheet.getCell(1,i).getContents();
        String size = writableSheet.getCell(2,i).getContents();
        String quantity = writableSheet.getCell(3,i).getContents();
        String errorMessage = writableSheet.getCell(4,i).getContents();


        //navigate to macys home page
        driver.navigate().to("https://www.macys.com");

        Thread.sleep(2500);

        //hover to Shop dep
        Reusable_Library.Hover(driver,"//*[@id='shopByDepartmentLabelText']","ShopbyDep");

        Thread.sleep(2500);

        //hover to men
        Reusable_Library.Hover(driver,"//*[@class='fob selected-flyout']","Men");

        Thread.sleep(3000);

        //click on jeans
        //Reusable_Library.click(driver,"//");






















        }//end of for loop

    }//end of main method


}//end java class
