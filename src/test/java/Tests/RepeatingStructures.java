package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class RepeatingStructures {

     public WebDriver driver;

     @Test
     public void iterateList (){
         driver = new ChromeDriver();
         driver.get("https://demoqa.com/sortable");
         driver.manage().window().maximize();

         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,400)");

         List <WebElement> listItems = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']" +
                 "//div[@class='list-group-item list-group-item-action']"));
         Actions actions = new Actions(driver);
         for (int i=0;i< listItems.size()-1;i++){
             WebElement currentElement = listItems.get(i);
             WebElement nextElement = listItems.get(i++);
             System.out.println("List element: " + currentElement.getText());
             actions.clickAndHold(currentElement)
                     .moveToElement (nextElement)
                     .release()
                     .build()
                     .perform();
         }

         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
}
