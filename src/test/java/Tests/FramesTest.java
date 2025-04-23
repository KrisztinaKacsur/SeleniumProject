package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesTest {

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

        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        framesElement.click();

        WebElement frameOneElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOneElement);

        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("The text from the first frame: " + sampleHeadingFrameElement.getText());

        //mutam focusul pe pagina principala, inafara iFrame-ului
        driver.switchTo().defaultContent();

        WebElement frameTwoElement = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frameTwoElement);

        js.executeScript("window.scrollBy(200,200)");
    }
}
