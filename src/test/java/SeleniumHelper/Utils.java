package SeleniumHelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Utils {
    public static WebDriver createDriverObj(int browserType) {
        WebDriver driver = null;

        switch (browserType) {
            case 1:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case 2:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case 3:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
        return driver;
    }
}
