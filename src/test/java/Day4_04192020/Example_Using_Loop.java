package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_Using_Loop {

    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path atleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

  //declare and define the driver
        WebDriver driver = new ChromeDriver();

        //create a dynamic array for Country
        String[] country = new String[5];
        country[0]= "USA";
        country[1]= "Canada";
        country[2]= "Bangladesh";
        country[3]= "India";
        country[4]= "UAE";

        //now creating for loop method
        for (int i = 0; i<country.length; i++){

       //open browser to go to bing home page
            driver.navigate().to("https://www.bing.com");

            //maximize the browser
            driver.manage().window().maximize();

            //wait for 2sec
            Thread.sleep(2000);

            //now inspecting elements
            driver.findElement(By.name("q")).sendKeys(country[i]);

            //now click on search
            driver.findElement(By.name("search")).submit();

            //now wait 2 sec;
            Thread.sleep(2000);

            //now find result
            String message = driver.findElement(By.id("b_tween")).getText();

           //split the search result
            String[] arrayResults = message.split(" ");
            System.out.println("My country is " + country[i]+ " My search result is " + arrayResults[0]);

          //wait for 2sec
            Thread.sleep(2000);


        }//end of loop
        driver.quit();






    }//end of main method




}//end of java class
