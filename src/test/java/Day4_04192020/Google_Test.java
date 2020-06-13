package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Test {

    public static void main(String[] args) throws InterruptedException {

   //set the system chrome driver path atleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
   System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

   //you declare and define the driver
        WebDriver driver = new ChromeDriver();

        //opening the browser automatically to go to google home page
        //driver.get("https://www.google.com");

        driver.navigate().to("http://www.google.com");

        //maximize your browser
        driver.manage().window().maximize();

        //wait few seconds after navigating to a page so browser can load properly
        //sleep statement handles in miliseconds so example 1 sec = 100 milisec.
        Thread.sleep(2000);

        //locate the search field by inspecting it first and then enter a keyword lets say car
        driver.findElement(By.name("q")). sendKeys("cars");

        //click on google search
        driver.findElement(By.name("btnK")). submit();

        Thread.sleep(2000);



        // to capture a text from web site you need to
        String message = driver.findElement(By.id("result-stats")).getText();
        //using array variable to split above message
        String[] arrayResult = message.split(" ");
        System.out.println("My search number is " + arrayResult[1]);

        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        //i prefer to use quit
        //driver.quit();

    }//end of main method




}//end of java class
