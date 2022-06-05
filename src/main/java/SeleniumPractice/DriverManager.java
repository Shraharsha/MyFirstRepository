package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    WebDriver driver;
    public WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HARI\\Desktop\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void kill(){
        driver.close();;
        driver.quit();
    }
}
