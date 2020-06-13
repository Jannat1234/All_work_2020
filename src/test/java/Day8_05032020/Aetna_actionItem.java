package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class Aetna_actionItem {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        //set some pre conditions using chromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for thr driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //arrayList for zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11219");
        zipCode.add("11214");

        ArrayList<Integer> milesRange = new ArrayList<>();
        milesRange.add(20);
        milesRange.add(35);
        milesRange.add(50);

        for (int i =0; i<zipCode.size(); i++) {

            //navigate to Aetna home page
            driver.navigate().to("http://www.aetna.com");

            //wait few sec
            Thread.sleep(4000);

            //verify title
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Health")) {
                System.out.println("Title matches with expected");
            } else {
                System.out.println("Title doesn't match " + actualTitle);
            }//end of if else

            //wait few sec
            Thread.sleep(3000);

            //click on Shop for plan
            try {
                driver.findElement(By.xpath("//*[@class='megamenu__primary--item']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate shop for plan " + e);
            }//end of catch

            //wait few sec
            Thread.sleep(3000);

            //call your mouse actions
            Actions mouse = new Actions(driver);

            //click on Medicare link
            try {
                WebElement mediCare = driver.findElement(By.xpath("//button[text()='Medicare']"));
                mouse.moveToElement(mediCare).click().perform();
            } catch (Exception e) {
                System.out.println("unable to locate medicare " + e);
            }//end of catch

            Thread.sleep(2000);

            //click find doc
            try {
                driver.findElements(By.xpath("//*[text()='Find a doctor ']")).get(0).click();
            } catch (Exception e) {
                System.out.println("unable to locate find doc " + e);
            }//end of catch

            //wait for few sec
            Thread.sleep(2000);

            //click on 2020 medicare plan
            try {
                driver.findElement(By.xpath("//*[@class='primaryPurple BtnWidth mgbutton w400']")).click();
            } catch (Exception e) {
                System.out.println("unable to locate 2020 medicare plan " + e);
            }// end of catch

            //wait for few sec
            Thread.sleep(2000);

            //enter zip code
            try {
                WebElement enterZip = driver.findElement(By.xpath("//*[@id='medZip']"));
                enterZip.clear();
                enterZip.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to locate zipcode " + e);
            }//end of catch

            //wait few sec
            Thread.sleep(3000);

            //click on matching zipcode link
            try {
                driver.findElement(By.xpath("//li[@ng-show='zipFilter.length']")).click();
            } catch (Exception e) {
                System.out.println("unable to click matching zipcode link " + e);
            }//end of catch

            //wait few sec
            Thread.sleep(2000);

            //range slider bar

















        }//end of loop



    }//end of main method

}//end java class
