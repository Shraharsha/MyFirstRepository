package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RahulShettyPractice {

    public WebDriver driver;
    public RahulShettyPractice(WebDriver driver){
        this.driver = driver;
    }

   /* public String getRahulShettyPracticeURL(){
        DriverManager drivermanager = new DriverManager();
        driver = drivermanager.chromeDriver();
      String BaseURL = "https://www.rahulshettyacademy.com/AutomationPractice/";
      return BaseURL;
    }*/

    public WebElement getRadio1Button() {
        return driver.findElement(By.xpath("//input[@value='radio1']"));
    }

    public WebElement getAutoCompleteElement() {
        return driver.findElement(By.id("autocomplete"));
    }

    public List<WebElement> getItemsFromAutoComplete() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li//div")));
        return driver.findElements(By.xpath("//*[@id='ui-id-1']//li//div"));
//        return driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));

    }

    public WebElement getDropDownElements() {
        return driver.findElement(By.id("dropdown-class-example"));
    }

    public List<WebElement> getCheckBox() {
       // return driver.findElements(By.xpath("//div[@id='checkbox-example']"));
        return driver.findElements(By.xpath("//input[@type='checkbox']"));

       /* public WebElement getCheckBox() {
            // return driver.findElements(By.xpath("//div[@id='checkbox-example']"));
            return driver.findElement(By.id("checkBoxOption1")); */
    }

    public WebElement clickOnButton() {
        return driver.findElement(By.xpath("//button[@id='openwindow']"));
    }

    public WebElement openNewTab() {
        return driver.findElement(By.id("opentab"));
    }

    public WebElement enterYourName() {
        return driver.findElement(By.id("name"));
    }

    public void clickOnAlertButton() {
        driver.findElement(By.id("alertbtn")).click();
    }
}

