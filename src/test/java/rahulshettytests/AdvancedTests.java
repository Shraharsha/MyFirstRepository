package rahulshettytests;

import SeleniumPractice.DriverManager;
import SeleniumPractice.RahulShettyPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Locale;

public class AdvancedTests {
    public WebDriver driver;
    RahulShettyPractice rahulShettyPractice;
    DriverManager driverManager = new DriverManager();


    @BeforeTest
    public void getURL() {
        driver = driverManager.chromeDriver();
        rahulShettyPractice = new RahulShettyPractice(driver);
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void sumOfElementsInAmountColumn() {
        int sum = 0, num = 0;
        List<WebElement> list = rahulShettyPractice.getListofElementsinAmountColumn();
        for (int i = 0; i < list.size(); i++) {
            num = Integer.parseInt(list.get(i).getText());
            sum = num + sum;
        }
        System.out.println("Sum of Elements in Amount Column = " + sum);

        int sumFromElement = Integer.parseInt(rahulShettyPractice.getTotalAmountCollected().getText().split(":")[1].trim());
        Assert.assertEquals(sumFromElement, sum);
    }

    @AfterTest
    public void endSession() {
        driverManager.kill();
    }

}
