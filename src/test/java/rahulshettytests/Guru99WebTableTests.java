package rahulshettytests;

import SeleniumPractice.DriverManager;
import SeleniumPractice.Guru99WebTablePractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class Guru99WebTableTests {
    WebDriver driver;
    DriverManager driverManager = new DriverManager();

    Guru99WebTablePractice guru99webtablepractice;


    @BeforeTest
    public void getURL(){
        driver = driverManager.chromeDriver();
        guru99webtablepractice = new Guru99WebTablePractice(driver);
        driver.get("https://demo.guru99.com/test/web-table-element.php");
    }

    @Test
    public void fetchNumberOfRowsAndColumn(){
        List<WebElement> col = guru99webtablepractice.numberOfColumns();
        System.out.println("Total number of columns are = "+col.size());

        List<WebElement> row = guru99webtablepractice.numberOfRows();
        System.out.println("Total number of rows are = "+row.size());
    }

    @Test
    public void fetchCellValue(){
        WebElement elements = guru99webtablepractice.getForthRowElements();
        System.out.println("4th Row Elements are - "+elements.getText());

        WebElement CellValue = guru99webtablepractice.getParticularCellValue();
        System.out.println("4th Row Elements are - "+CellValue.getText());
    }

    @Test
    public void MaxValueOfAllCellsInAColumn() {
        Double num, m, r = Double.valueOf(0);
        List<WebElement> elements = guru99webtablepractice.getListofAllCurrentPricesColumn();
        for (int i = 0; i < elements.size(); i++) {
            num =  Double.parseDouble(elements.get(i).getText());
            if (num > r) {
                r = num;
            }
        }
        System.out.println("Maximum current price is = " + r);

    }

    @AfterTest
    public void endSession(){
        driverManager.kill();
    }



}
