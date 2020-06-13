package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Action_USPS {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        //set some pre conditions using chromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for thr driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to USPS
        driver.navigate().to("https://www.usps.com");

        Thread.sleep(2500);

        //call your mouse actions
        Actions mouse = new Actions(driver);

        //hover to Mail and Ship tab
        try {
            WebElement mailAndShip = driver.findElement(By.xpath("//*[text()='Mail & Ship']"));
            //call your Actions command to move to the element
            mouse.moveToElement(mailAndShip).perform();
        }catch (Exception e) {
          System.out.println("Unable to locate Mail & Ship " + e);
        }//end of Main & ship Exception

        try {
            WebElement clickAndShip = driver.findElement(By.xpath("//a[text()='Click-N-Ship']"));
            //call your Actions command to move to the element
            mouse.moveToElement(clickAndShip).click().perform();
            //this is to submit using mouse actions
            //clickAndShip.submit();
            //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform();
        }catch (Exception e) {
            System.out.println("Unable to locate Click-N-Ship " + e);
        }

    }//end of main


}//end of java class
