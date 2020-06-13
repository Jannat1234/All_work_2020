package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_mortgage_calculator {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        //set some pre conditions using chromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for thr driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator home page
        driver.navigate().to("http://mortgagecalculator.org");

      Thread.sleep(2500);

      //declare and define javascript
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scroll all the way to the bottom of the page
       // jse.executeScript("scroll(0,5000)");
        //Thread.sleep(1000);
        //scroll all the way to the top pf the page
        //jse.executeScript("scroll(0,-5000)");

        //scrolling to an element view for loan term
        try {
            WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",homeValue);
        }catch (Exception e) {
            System.out.println("Unable to locate Loan Term " + e);
        }//end of home value

    }//end of main



}//end of class
