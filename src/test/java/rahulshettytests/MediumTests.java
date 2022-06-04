package rahulshettytests;

import SeleniumPractice.DriverManager;
import SeleniumPractice.RahulShettyPractice;
import com.sun.jdi.ThreadGroupReference;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MediumTests {

    public WebDriver driver;
    RahulShettyPractice rahulShettyPractice;

    @BeforeTest
    public void getURL() {
        DriverManager drivermanager = new DriverManager();
        driver = drivermanager.chromeDriver();
        rahulShettyPractice = new RahulShettyPractice(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String BaseURL = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(BaseURL);
    }

    @Test(priority = 1)
    public void switchWindow() {
        WebElement button = rahulShettyPractice.clickOnButton();
        button.click();
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle is= " + mainWindowHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Child Window Handle is= " + allWindowHandles);

        //Lets try alternate method by removing parent window handle from allwindowhandles string set.
        allWindowHandles.remove(mainWindowHandle);

        Iterator<String> i = allWindowHandles.iterator();


        while (i.hasNext()) {
            String childWindow = i.next();
            //    if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
            driver.switchTo().window(childWindow);
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='NO THANKS']")));
            driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
            WebElement element = driver.findElement(By.linkText("COURSES"));
            element.click();
            System.out.println(driver.getTitle());
            Assert.assertEquals("Rahul Shetty Academy", driver.getTitle());
            //TODO: close child window
            driver.close();
        }
        //  }
        driver.switchTo().window(mainWindowHandle);
    }

    @Test(priority = 2)
    public void switchTabs() {

        WebElement openTab = rahulShettyPractice.openNewTab();
        openTab.click();
        String ParentTab = driver.getWindowHandle();
        ArrayList<String> ChildTabs = new ArrayList<String>(driver.getWindowHandles());

        //Lets try alternate method, without removing Parent tab from child tab array list.
        //  ChildTabs.remove(ParentTab);
        Iterator<String> i = ChildTabs.iterator();
        while (i.hasNext()) {
            String ChTab = i.next();
            if (!ParentTab.equalsIgnoreCase(ChTab)) {
                driver.switchTo().window(ChTab);
                WebElement element = driver.findElement(By.linkText("LOGIN"));
                element.click();
                Assert.assertEquals("Rahul Shetty Academy", driver.getTitle());
                System.out.println(driver.getTitle());
                driver.close();

                driver.switchTo().window(ParentTab);
                Assert.assertEquals("Practice Page", driver.getTitle());
                System.out.println(driver.getTitle());
            }

        }
    }
       /* driver.switchTo().window(ChildTabs.get(0));

        WebElement element = driver.findElement(By.linkText("LOGIN"));
        element.click();
        driver.close();

        driver.switchTo().window(ParentTab);
    }*/

    @Test(priority = 3)
//    public void switchAlert(String Name) {
    public void switchAlert() {
        WebElement enterName = rahulShettyPractice.enterYourName();
//        enterName.sendKeys(Name);
        enterName.sendKeys("kakkapiya");
//        Assert.assertEquals("Harsha", driver.findElement(By.id("name")).getText());
        System.out.println(driver.findElement(By.id("name")).getText());
        rahulShettyPractice.clickOnAlertButton();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        alert.accept();

    }

    @AfterTest
    public void EndSession() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
