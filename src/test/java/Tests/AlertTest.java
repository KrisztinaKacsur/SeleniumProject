package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;

    @Test
    public void automationMethod () {
        //deschidem un browser Chrome:
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //facem browser-ul in modul maximize
        driver.manage().window().maximize();
        //facem scroll pe pagina
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertsFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFrameWindowElement.click();

        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertElement.click();

        WebElement simpleClickMeElement = driver.findElement(By.id("alertButton"));
        simpleClickMeElement.click();

        //cum interactionam cu alerta? ne mutam cu focusul pe alerta
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();

        WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
        alertDelayElement.click();

        //definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertDelayOk = driver.switchTo().alert();
        alertDelayOk.accept();

        WebElement alertConfirmElement = driver.findElement(By.id("confirmButton"));
        alertConfirmElement.click();

        Alert alertConfirm = driver.switchTo().alert();
        alertConfirm.dismiss();

        //TEMA: assert "You selected cancel"

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        alertPromptElement.click();

        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys("Krisz");
        alertPrompt.accept();
    }
}
