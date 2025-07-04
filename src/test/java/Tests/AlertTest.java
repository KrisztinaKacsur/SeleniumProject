package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public AlertMethods alertMethods;

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

        elementsMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);

        //facem scroll pe pagina
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertsFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethods.elementClick(alertsFrameWindowElement);

        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementsMethods.elementClick(alertElement);

        WebElement simpleClickMeElement = driver.findElement(By.id("alertButton"));
        elementsMethods.elementClick(simpleClickMeElement);

        //cum interactionam cu alerta? ne mutam cu focusul pe alerta
        alertMethods.interactWithAlertsOK();

        WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.elementClick(alertDelayElement);

        alertMethods.interactWithDelayAlert();

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
