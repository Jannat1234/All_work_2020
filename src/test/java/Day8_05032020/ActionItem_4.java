package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem_4 {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        //set some pre conditions using chromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for thr driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //arrayList for zip z=code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11219");
        zipCode.add("11214");


        //arrayList for referralCode
        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("1122");
        referralCode.add("5533");
        referralCode.add("9090");


        //arrayList for dentalProgram
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        for (int i = 0; i<zipCode.size(); i++) {


            //navigate to metlife website
            driver.navigate().to("http://www.metlife.com");
             //wait few seconds
            Thread.sleep(2000);

            //verify title
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Insurance & Employee Benefit | Metlife")) {
                System.out.println("Title matches with expected");
            } else {
                System.out.println("Title doesn't match " + actualTitle);
            }//end of if else

            //click on Solutions tab using try and catch
            try {
                driver.findElement(By.xpath("//*[@class='header__navigation-container-menu-item']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate Solutions " + e);
            }//end of catch

            //wait few seconds
            Thread.sleep(2000);

            //click on Metlife take along dental
            try {
                driver.findElement(By.xpath("//a[text()='MetLife TakeAlong Dental']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate Metlife take along Dental " + e);
            }//end of catch

            Thread.sleep(2000);

            //verify title of the page
            String pageTitle = driver.getTitle();
            if (pageTitle.equals("MetLife TakeAlong Dental | MetLife")) {
                System.out.println(" Title matches with expected ");
            } else {
                System.out.println("Title matches with expected " + pageTitle);
            }// end of if else


            //click on Enroll now using try and catch
            try {
                driver.findElement(By.xpath("//*[@class='btn-brand-2nd table']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click Enroll now " + e);
            }//end of catch

            //wait few seconds
            Thread.sleep(2000);

            //define arrayList for new window
            ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

            //switch to new window
            driver.switchTo().window(newTab.get(1));

            //wait few seconds
            Thread.sleep(2000);

            //now enter zip code using try and catch
            try {
                WebElement enterZip = driver.findElement(By.xpath("//*[@class='form-control']"));
                enterZip.clear();
                enterZip.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to locate zipcode " + e);
            }//end of catch

            //now submit zip
            try {
                driver.findElement(By.xpath("//*[@id='txtZipCodetxt']")).click();
                //wait few seconds
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("unable to click Go " + e);

            }//end of catch


            //choose ppo type
            try {
                driver.findElement(By.xpath("//*[@class='" + dentalProgram.get(i) + "']" )).click();
            }catch (Exception e) {
                System.out.println("unable to click ppo type " + e);
            }//end of catch

            //wait few sec
            Thread.sleep(2000);

            //click on Enroll in program using try and catch
            try{
                driver.findElement(By.xpath("//*[@id='topenrolltab']")).click();
            } catch (Exception e) {
                System.out.println("unable to locate Enroll in program " + e);
            }//end of catch

            //wait few sec
            Thread.sleep(2000);

            // now enter referral code
            try {
                WebElement enterReferral = driver.findElement(By.xpath("//*[@id='txtBxPromocode']"));
                enterReferral.sendKeys(referralCode.get(i));
            }catch (Exception e) {
                System.out.println("unable to locate referral code " + e);
            }//end of catch

            //wait few sec
            Thread.sleep(2000);

            //click on GO button
            try {
                driver.findElement(By.xpath("//*[@name='btnEnroll']")).click();
            } catch (Exception e) {
                System.out.println("unable to locate Go button " + e);
            }//end of catch

            //wait few sec
            Thread.sleep(2000);

            // capture red error message
            try {
                WebElement errorMessage = driver.findElement(By.xpath("//*[@id='lblRefCodeError']"));
                System.out.println("the error message is " + errorMessage.getText());
            } catch (Exception e) {
                System.out.println("unable to locate error message " + e);
            } //end of catch


            //wait few sec
            Thread.sleep(2000);

            //Enroll without referral code
            try {
                driver.findElement(By.xpath("//*[@id='withoutrefcode']")).click();
            } catch (Exception e) {
                System.out.println("unable to locate referral code " + e);
            }//end of catch

            //wait few sec
            Thread.sleep(2000);

            //Capture the PPO title using try and catch
            try {
                WebElement ppoTittle = driver.findElement(By.xpath("//*[@class='col-sm-8']"));
                if (ppoTittle.getText().contains(dentalProgram.get(i))) {
                    System.out.println("PPO Title matches with expected PPO " + ppoTittle.getText());
                } else {
                    System.out.println("PPO Title does not match " + ppoTittle.getText());
                }//end of if and else
            }catch (Exception e) {
                System.out.println("unable to locate PPO Title " + e);
            }//end of try and catch

            //wait few sec
            Thread.sleep(2000);

            //close current tab
            driver.close();

            //wait few sec
            Thread.sleep(2000);

            //switch to your default tab
            driver.switchTo().window(newTab.get(0));

            //wait few sec
            Thread.sleep(2000);




        }//end of for loop

        //quit browser
        driver.quit();

    }//end of main method


}//end of java class
