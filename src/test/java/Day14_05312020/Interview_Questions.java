package Day14_05312020;

import Day13_05302020.List_Boolean;
import Reusable_class.Abstract_class;
import com.sun.source.tree.TryTree;
import net.bytebuddy.implementation.EqualsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class Interview_Questions extends Abstract_class {

    @Test
    public void YahooResult() throws InterruptedException {

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //wait  2 sec
        Thread.sleep(2000);
        //now search for QA
        driver.findElement(By.xpath("//*[@id='header-search-input']")).sendKeys("QA");

        //inspect search and click
        driver.findElement(By.xpath("//*[@id='header-desktop-search-button']")).click();
        Thread.sleep(2000);
        //scroll down and click QA
        driver.findElement(By.xpath("//*[text()='Quality assurance - Wikipedia']")).click();
        Thread.sleep(2000);
        //define arrayList for new window
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

        //switch to new window
        driver.switchTo().window(newTab.get(1));


        //page contains the phrase “Middle Ages”
        boolean Text = driver.getPageSource().contains("Middle Ages");
        if (Text == true) {
            System.out.println("page contain the expected text");
        } else {
            System.out.println("page does not contain the expected text");
        }//end of else

        driver.close();
        driver.switchTo().window(newTab.get(0));

    }//end of test1

    @Test
    public void clickCheckbox() throws InterruptedException {
        //navigate to the page
        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html");
        Thread.sleep(2000);

        //click all check box
        List<WebElement> elements = driver.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println("total checkboxes are " + elements.size());
        for (WebElement TotalBox : elements) {
            TotalBox.click();
        } // end for

    }//end of test 2

    @Test
    public void outputCounts() {

        for (int i = 0; i <= 100; i++) {
            if (i % 5 == 0) {
            } else {
                System.out.println(i);
            }//end for if else
        }//end of for loop

    }//end of test 3

    @Test
    public void quickScript() {
    //create arraylist
        String[] List = new String[5];
        List[0] = "a";
        List[1] = "b";
        List[2] = "c";
        List[3] = "d";
        List[4] = "e";
        for (int i = 0; i < List.length; i++) {
            if (List[i].equals("a")||List[i].equals("e")){
                System.out.println(" Vowel");
            }else {
                System.out.println(" Non-Vowel");
            }//end of if else
        }//end of for loop


    }//end of test


}//end of class


