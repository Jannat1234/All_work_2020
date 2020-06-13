package Day5_4252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_By_Xpath {

    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path atleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

   //define the driver
        WebDriver driver = new ChromeDriver();

        //navigate the amazon home page
        driver.navigate().to("http://www.amazon.com");

        //maximize your driver window
        driver.manage().window().maximize();

        //wait few seconds
        Thread.sleep(2000);

        //enter a keyword laptop on amazon search field by using Xpath
        driver.findElement(By.xpath("//*[@name= 'field-keywords']")). sendKeys("laptop");

       //click on search icon
        driver.findElement(By.xpath("//*[@type='submit' or @value='Go']")).submit();
        Thread.sleep(2500);

        //click on second image item of the same elements within that page using index number
        driver.findElements(By.xpath("//*[@class= 's-image']")). get(1). click();



    }//end of main




}//end of java class
