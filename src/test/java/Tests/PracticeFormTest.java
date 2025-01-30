package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void automationMethod () {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement formsField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsField.click();

        WebElement practiceFormBtn = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormBtn.click();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Pam";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lasNameValue = "Beesly";
        lastNameField.sendKeys(lasNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "pam.beesly@gmail.com";
        emailField.sendKeys(emailValue);

        //are si ID, dar folosim CSS acum
        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "0714558796";
        mobileNumberField.sendKeys(mobileNumberValue);

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/testPhoto.jpg");
        pictureElement.sendKeys(file.getAbsolutePath());

        WebElement maleRadioBtn = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleRadioBtn = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherRadioBtn = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Female";

        if (maleRadioBtn.getText().equals(genderValue)){
            maleRadioBtn.click();
        }
        else if (femaleRadioBtn.getText().equals(genderValue)){
            femaleRadioBtn.click();
        }
        else if (otherRadioBtn.getText().equals(genderValue)){
            otherRadioBtn.click();
        }

    }
}
