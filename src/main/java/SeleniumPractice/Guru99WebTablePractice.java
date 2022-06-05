package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Guru99WebTablePractice {

    public WebDriver driver;

    public Guru99WebTablePractice(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> numberOfColumns(){
        return driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
    }

    public List<WebElement> numberOfRows() {
        return driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
    }

    public WebElement getForthRowElements() {
        return driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[4]"));
    }

    public WebElement getParticularCellValue() {
        return driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[4]/td"));
    }

    public List<WebElement> getListofAllCurrentPricesColumn() {
        return driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr/td[4]"));
    }
}
