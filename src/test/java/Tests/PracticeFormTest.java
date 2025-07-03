package Tests;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;
    public ElementsMethods elementsMethods;

    @Test
    public void automationMethod () {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement formsField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementsMethods.elementClick(formsField);

        WebElement practiceFormBtn = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethods.elementClick(practiceFormBtn);

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(firstNameField, "Pam");

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(lastNameField,"Beesly");

        WebElement emailField = driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(emailField, "pam.beesly@gmail.com");

        //are si ID, dar folosim CSS acum
        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementsMethods.fillElement(mobileNumberField, "0714558796");

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        elementsMethods.uploadPicture(pictureElement);

        WebElement maleRadioBtn = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleRadioBtn = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherRadioBtn = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        List<WebElement> genderElement = new ArrayList<>();
        genderElement.add(maleRadioBtn);
        genderElement.add(femaleRadioBtn);
        genderElement.add(otherRadioBtn);

        elementsMethods.selectElementFromListByText(genderElement,"Female");

        WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
        String subjectValues = "Social Studies";
        subjectsField.sendKeys(subjectValues);
        subjectsField.sendKeys(Keys.ENTER);

        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        //click fortat pentru ca avem reclama
        js.executeScript("arguments[0].click();", stateDropdown);
        stateDropdown.sendKeys("Haryana");
        stateDropdown.sendKeys(Keys.ENTER);

        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));
        cityDropdown.sendKeys("Panipat");
        cityDropdown.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitElement);
    }
}
