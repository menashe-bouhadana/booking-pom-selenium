package booking.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BaseMethods {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BaseMethods(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findMultipleElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getTextByLocator(By locator) {
        return driver.findElement(locator).getText();
    }

    public WebElement typeInto(By locator, String inputText) {
        findElement(locator).sendKeys(inputText);
        return findElement(locator);
    }

    public void removeInput(By locator) {
        for (int i = 0; i < 50; i++) {
            findElement(locator).sendKeys(Keys.BACK_SPACE);
        }
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void impWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void fluentWait(int timeout, int polling, By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return findElement(locator);
            }
        });
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void selectFromDropDownListByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public void selectFromDropDownListByVisibleText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    public void selectFromDropDownListByIndex(By locator, int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }


    public void nextTab() {
        driver.switchTo().window(driver.getWindowHandle());
    }

    public void switchTab() {
        String parentID = driver.getWindowHandle();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

        for (String handle : tabs2) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("your wish")) {
                break;
            }
        }
    }
}
