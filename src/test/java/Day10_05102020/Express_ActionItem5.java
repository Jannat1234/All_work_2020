package Day10_05102020;

import Reusable_class.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Express_ActionItem5 {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

      //locate readableFile
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Express_Shopping.xls"));

        //locate the readable worksheet by index
        Sheet readableSheet = readableFile.getSheet(0);

        //open readable file through desktop command
        Desktop.getDesktop().open(new File("src\\Resource\\Express_Shopping.xls"));


        //we need to create a writable workbook to mimic readable file because we shouldn't be writing on readable file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/Resource/Express_Shopping_Result.xls"),readableFile);

        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);

        //get the total rows that are not empty
        int rows = writableSheet.getRows();

        //define the web driver using reusable library
        WebDriver driver = Reusable_Library.setDriver();

        //define the for loop
        for (int i=1; i < rows; i++) {

       //store column as String Variable
            String size = writableSheet.getCell(0,i).getContents();
            String Quantity = writableSheet.getCell(1,i).getContents();
            String firstName = writableSheet.getCell(2,i).getContents();
            String lastName = writableSheet.getCell(3,i).getContents();
            String email = writableSheet.getCell(4,i).getContents();
            String phoneNumber = writableSheet.getCell(5,i).getContents();
            String streetAdd = writableSheet.getCell(6,i).getContents();
            String zipCode = writableSheet.getCell(7,i).getContents();
            String city = writableSheet.getCell(8,i).getContents();
            String state = writableSheet.getCell(9,i).getContents();
            String cardNumber = writableSheet.getCell(10,i).getContents();
            String expirationMonth = writableSheet.getCell(11,i).getContents();
            String expirationYear = writableSheet.getCell(12,i).getContents();
            String cvvCode = writableSheet.getCell(13,i).getContents();
            String errorMessage = writableSheet.getCell(14,i).getContents();

            //navigate express home page
            driver.navigate().to("https://www.express.com");

            //wait few sec
            Thread.sleep(2000);

            //hover to women tab
            Reusable_Library.Hover(driver,"//a[text()='Women']","Women");
            //wait few sec
            Thread.sleep(2000);

            //click on dress
            Reusable_Library.MouseClick(driver,"//a[text()='Dresses']", "dress");
            //wait few sec
            Thread.sleep(5000);

            //select the First dress
            Reusable_Library.click(driver,"//a[text()='off the shoulder ruffle maxi dress']","Maxi Dress");
            //wait few sec
            Thread.sleep(2500);

            //Select size
            Reusable_Library.click(driver, "//button[@value='"+ size +"']","size");

            //wait few sec
            Thread.sleep(2500);

            //add to the Bag
            Reusable_Library.click(driver,"//*[text()='Add to Bag']","AddToBag");
            //wait few sec
            Thread.sleep(2500);

          //Hover view bag
            Reusable_Library.Hover(driver,"//div[@class='DesktopHeader_icons__25y0X ravenDesktopIcons']/div[3]", "hoverToBag");
            //wait few sec
            Thread.sleep(2500);


            //View Bag &Checkout button
            Reusable_Library.click(driver, "//a[text()='View Bag & Check Out']","viewBag");
            //wait few sec
            Thread.sleep(2500);

            //Select Quantity
            Reusable_Library.dropdownByText(driver,"//*[@id='qdd-0-quantity']",Quantity,"quantity");
            //wait few sec
            Thread.sleep(2500);

            //click on checkout
            Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _1s_-v']","Checkout");
            //wait few sec
            Thread.sleep(2500);

            //click on continue as guest
            Reusable_Library.click(driver,"//*[text()='Continue as Guest']","clickGuest");

            //wait few sec
            Thread.sleep(2500);

            //enter first name
            Reusable_Library.userKeys(driver,"//*[@id='contact-information-firstname']",firstName,"firstName");

            //enter last name
            Reusable_Library.userKeys(driver, "//*[@name='lastname']",lastName,"lastName");

            //enter Email
            Reusable_Library.userKeys(driver,"//input[@name='email']",email,"Email");

            //Reenter Email
            Reusable_Library.userKeys(driver,"//*[@name='confirmEmail']",email,"Email");

            //enter phone number
            Reusable_Library.userKeys(driver,"//*[@name='phone']",phoneNumber,"phoneNumber");
            //wait few sec
            Thread.sleep(2500);

            //Click Continue
            Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            //wait few sec
            Thread.sleep(2500);

            //Enter street address
            Reusable_Library.userKeys(driver,"//*[@name='shipping.line1']",streetAdd,"StreetAdd");

            //enter Zip
            Reusable_Library.userKeys(driver,"//*[@name='shipping.postalCode']",zipCode,"ZipCode");

            //enter city
            Reusable_Library.userKeys(driver,"//*[@name='shipping.city']",city,"City");

            //Select State
            Reusable_Library.dropdownByText(driver,"//*[@name='shipping.state']",state,"State");

            //click Continue
            Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            //wait few sec
            Thread.sleep(2500);

            //click continue Again
            Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            //wait few sec
            Thread.sleep(2500);

            //enter cardNumber
            Reusable_Library.userKeys(driver,"//*[@name='creditCardNumber']",cardNumber,"CardNumber");
            //wait few sec
            Thread.sleep(2500);

            //enter exp Month
            Reusable_Library.dropdownByText(driver,"//*[@name='expMonth']",expirationMonth,"EXPMonth");

            //enter exp year
            Reusable_Library.dropdownByText(driver,"//*[@name='expYear']",expirationYear,"EXPYear");

            //enter cvvCode
            Reusable_Library.userKeys(driver,"//*[@name='cvv']",cvvCode,"CVV");

            //click place order
            Reusable_Library.click(driver,"//*[text()='Place Order']","placeOrder");
            //wait few sec
            Thread.sleep(2500);

            //An error Message
            String result = Reusable_Library.captureText(driver,"//*[@id='rvn-note-NaN']","search Result");

            System.out.println("My error message is " + result);

            //write the search number result back to writable sheet
            Label label = new Label(14,i, result);

            //adding back to writable cell
            writableSheet.addCell(label);

           //clear the Shopping bag
            driver.manage().deleteAllCookies();


        }//end of for loop

        //outside of loop
        writableFile.write();
        writableFile.close();
        readableFile.close();

        //quit the driver
        driver.quit();

        //open writable results
        Desktop.getDesktop().open(new File("src\\Resource\\Express_Shopping_Result.xls"));




    }//end of main

}//end of java class
