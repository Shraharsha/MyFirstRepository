package rahulshettytests;

import SeleniumPractice.DriverManager;
import SeleniumPractice.RahulShettyPractice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasicTests {


    public WebDriver driver;
    RahulShettyPractice rahulShettyPractice;

    @BeforeTest
    public void getURL() {

        DriverManager drivermanager = new DriverManager();
        driver = drivermanager.chromeDriver();
        rahulShettyPractice = new RahulShettyPractice(driver);
        String BaseURL = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(BaseURL);

    }

    @Test
    public void radioButton() {
        WebElement radio1 = rahulShettyPractice.getRadio1Button();
        if (radio1.isSelected()) {
            System.out.println("Radio1 is Enabled");
        } else {
            radio1.click();
        }
        boolean selected = radio1.isSelected();
        Assert.assertTrue(selected);
        System.out.println("Radio Button test is passed.");

    }

    @Test
    public void autoCompleteTest() throws InterruptedException {
        //    Actions Country = new Actions(driver);
        WebElement autoCompleteElement = rahulShettyPractice.getAutoCompleteElement();
        autoCompleteElement.sendKeys("Ind");
        List<WebElement> itemsFromAutoComplete = rahulShettyPractice.getItemsFromAutoComplete();
        for (WebElement item : itemsFromAutoComplete) {
           // System.out.println(item.getText());
            if (item.getText().equalsIgnoreCase("india")) {
                item.click();
                WebDriverWait wait = new WebDriverWait(driver,30);
                wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("autocomplete"),"India"));
                String s = driver.findElement(By.id("autocomplete")).getText();
                System.out.println(s);
                Assert.assertEquals("India", driver.findElement(By.id("autocomplete")).getText());
                break;
            }
        }

    }

    @Test
    public void dropDownTest() {
        WebElement dropDown = rahulShettyPractice.getDropDownElements();
        Select option = new Select(dropDown);
        option.selectByVisibleText("Option2");
        String s = driver.findElement(By.id("dropdown-class-example")).getText();
        Assert.assertEquals("Option2",s);
        System.out.println("Congratulations! Drop Down Test is passed.");
    }

    @Test
    public void checkBoxTest() {
     /*   WebElement CheckBoxElement = rahulShettyPractice.getCheckBox();
        if (CheckBoxElement.isSelected()){
            System.out.println("CheckBox is Enabled");
        }
        else {
            CheckBoxElement.click();
        }*/
        List<WebElement> checkBoxElements = rahulShettyPractice.getCheckBox();
        // int size = checkBoxElements.size();
        for (WebElement element : checkBoxElements) {
            //  System.out.println(i.getText());
            //   String value = element.getAttribute("id");
            element.click();
        }
        Boolean selected = driver.findElement(By.id("checkBoxOption1")).isSelected();
        Boolean selected1 = driver.findElement(By.id("checkBoxOption2")).isSelected();
        Boolean selected2 = driver.findElement(By.id("checkBoxOption3")).isSelected();
        Assert.assertTrue(selected);
        Assert.assertTrue(selected1);
        Assert.assertTrue(selected2);
        System.out.println("Yayeee! All the tests are passed.");


    }

    @AfterTest
    public void endSession() throws InterruptedException {
        Thread.sleep(2200);
        driver.close();
        driver.quit();
    }

}
