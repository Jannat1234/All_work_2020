package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action_Item2 {

    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path atleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");


        //declare and define the Driver
        WebDriver driver = new ChromeDriver();

        //create a dynamic array for state
        String[] state = new String[5];
        state[0] = "New York";
        state[1] = "New Jersey";
        state[2] = "California";
        state[3] = "ohio";
        state[4] = "Georgia";

        //now creating for loop method
        for (int i = 0; i < state.length; i++) {

            //open browser automatically to open bing home page
            driver.navigate().to("https://www.bing.com");

            //maximize the browser
            driver.manage().window().maximize();

            //wait for 3 sec
            Thread.sleep(3000);

            //now inspecting elements
            driver.findElement(By.name("q")).sendKeys(state[i]);

            //now click on search
            driver.findElement(By.name("search")).submit();

            //wait another 2 sec
            Thread.sleep(2000);

            //now find result
            String message = driver.findElement(By.id("b_tween")).getText();

            //now split the search results
            String[] arrayResults = message.split(" ");
            System.out.println("My state is " + state[i] + " my search result number is " + arrayResults[0]);

            //wait 2sec again
            Thread.sleep(2000);


        }//end of loop
        driver.quit();


    }//end of main method


}//end of java class
