package Day7_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Met_life_Tabs {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        //set some pre conditions using chromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for thr driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to met life home page
        driver.navigate().to("http://www.metlife.com");
        //wait few seconds
        Thread.sleep(2500);
        //click on solution tab
        try {
            driver.findElement(By.xpath("//*[contains (text(),'SOLUTION')]")).click();
        }catch(Exception e) {
            System.out.println("unable to click on solution " +e);

            Thread.sleep(2000);

        }//end of catch

        Thread.sleep(3500);

        try {
            //locate the search field by inspecting it first then enter a keyword "car"
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
        } catch (Exception e) {
            System.out.println("unable to click on Solution " + e);
        }//end of catch
        try {
            //locate the search field by inspecting it first then enter a keyword "car"
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
        } catch (Exception e) {
            System.out.println("unable to click on MetLife TakeAlong Dental Link " + e);
        }//end of catch


        //click on Enrol Now
        try {
          driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Enrol now " + e);
        }//end of Enrol Now exception

        //now define the ArrayList to handle all current window tabs that are open
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo() .window(tabs.get(1));

        //enter your zip code

        try {
            driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11218");

            Thread.sleep(2000);
        }catch (Exception e) {
            System.out.println("Unable to enter on Search Field " + e);
        }//end of Zip Code exception

        Thread.sleep(1500);

        // i want to close this tab
        driver.close();

        //switch to previous tab
        driver.switchTo().window(tabs.get(0));
        driver.quit();

    }//end of main method

}//end of java class
