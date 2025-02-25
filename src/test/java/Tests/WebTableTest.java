package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod (){
        //deschidem un browser Chrome:
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //facem browser-ul in modul maximize
        driver.manage().window().maximize();
        //facem scroll pe pagina
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declaram un element = "Elements" - Home page
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsField.click();
        //declaram un element = "Web Tables" - from Side Menu
        WebElement webTablesBtn = driver.findElement(By.id("item-3"));
        webTablesBtn.click();

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tableElements.size();

        //declaram un elemnt = "Add" button
        WebElement addBtn = driver.findElement(By.id("addNewRecordButton"));
        addBtn.click();

        //First name input field
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Test";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Name";
        lastNameField.sendKeys(lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailFieldValue = "testmail@gmail.com";
        emailField.sendKeys(emailFieldValue);

        WebElement ageField = driver.findElement(By.id("age"));
        String ageFieldValue = "23";
        ageField.sendKeys(ageFieldValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        String salaryFieldValue = "1250";
        salaryField.sendKeys(salaryFieldValue);

        WebElement departmentField = driver.findElement(By.id("department"));
        String departmentFieldValue = "Sales";
        departmentField.sendKeys(departmentFieldValue);

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        List<WebElement> expectedTableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize +1;

        Assert.assertEquals(expectedTableElements.size(), expectedTableSize);

        String actualTableValue = expectedTableElements.get(3).getText();

        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailFieldValue));
        Assert.assertTrue(actualTableValue.contains(ageFieldValue));
        Assert.assertTrue(actualTableValue.contains(salaryFieldValue));
        Assert.assertTrue(actualTableValue.contains(departmentFieldValue));

        //inchidem browser-ul
        //driver.quit();

    }
}
