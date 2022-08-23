package booking.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

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
        for(int i =0; i < 50; i++) {
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

    public void click(By locator) {
        findElement(locator).click();
    }

    public void visit(String url) {
        driver.get(url);
    }
}
