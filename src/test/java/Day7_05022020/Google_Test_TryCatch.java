package Day7_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_Test_TryCatch {

    public static void main(String[] args) throws InterruptedException {

   //set the system chrome driver path atleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
   System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

        //you declare and define the driver
        WebDriver driver = new ChromeDriver();


        // set the ArrayList for the class
        //dont need ti define the size/length and also dont need to define the index numbers
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Lexus");
        cars.add("Toyota");
        cars.add("BMW");

        for (int i = 0; i < cars.size(); i++) {


            //opening the browser automatically to go to google home page
            //driver.get("https://www.google.com");

            driver.navigate().to("http://www.google.com");

            //maximize your browser
            driver.manage().window().maximize();

            //wait few seconds after navigating to a page so browser can load properly
            //sleep statement handles in miliseconds so example 1 sec = 100 milisec.
            Thread.sleep(2000);

            try {
                //locate the search field by inspecting it first and then enter a keyword let say cars
                WebElement search = driver.findElement(By.xpath("//*[@name='q']"));
                search.sendKeys(cars.get(i));
            } catch (Exception e) {
                System.out.println("unable to enter data on search field " + e);
            }//end of search field exception

            try {
                driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            } catch (Exception e) {
                System.out.println("unable to submit on search Icon " + e);
            }//end of search icon exception

            //wait few seconds
            Thread.sleep(2000);

            try {
                //to capture a text from web site you need to
                String message = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
                //using array variable to split above message
                String[] arrayResult = message.split(" ");
                System.out.println("My search number is " + arrayResult[1]);
            } catch (Exception e) {
                System.out.println("unable to capture on search result " + e);
                //screenshot
            }//end of search result exception

            Thread.sleep(2000);

        }//end of for loop





        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        //i prefer to use quit
        //driver.quit();

    }//end of main method




}//end of java class
