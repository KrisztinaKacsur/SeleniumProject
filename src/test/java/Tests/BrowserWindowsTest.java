package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTest {
    public WebDriver driver;

    @Test
    public void automationMethod () {
        //deschidem un browser Chrome:
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //facem browser-ul in modul maximize
        driver.manage().window().maximize();
        //facem scroll pe pagina
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertsFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFrameWindowElement.click();

        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsElement.click();

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("The text from the new tab: " + sampleHeadingElement.getText());

        driver.close();
        driver.switchTo().window(tabList.get(0));

        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("The text from the new window: " + sampleHeadingWindowElement.getText());

        driver.close();
        driver.switchTo().window(windowList.get(0));
    }
}
