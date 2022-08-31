package Pages;

import SeleniumHelper.BaseMethods;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

public class PageBookingResults extends BaseMethods {
    public PageBookingResults(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Wait for all results to load")
    public void waitForResultsToLoad() {
        waitUntilElementVisible(By.cssSelector(".d3a14d00da"));
    }

    @Step("Count how many search results received")
    public void countForSearchResults() {
        String resultCount = getTextByLocator(By.cssSelector(".d3a14d00da"));
        System.out.println(resultCount);

        Allure.addAttachment(resultCount, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click on the checkbox with breakfest included")
    public void checkboxBreakfastIncluded() {
        waitUntilElementVisible(By.cssSelector("div[data-filters-item=\"popular:mealplan=1\"]"));
        click(By.cssSelector("div[data-filters-item=\"popular:mealplan=1\"]"));
        Allure.addAttachment("Click on the checkbox with breakfest included", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click on the first search result item")
    public void checkAvailabilityForFirstResult() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        By checkButton = By.cssSelector("div:nth-child(2) > div.d20f4628d0 > div.b978843432 > div > div.d7449d770c.a081c98c6f > div.e41894cca1 > div > div.a68bfa09c2 > a");
        By checkButton2 = By.cssSelector("div:nth-child(3) > div.d20f4628d0 > div.b978843432 > div > div.d7449d770c.a081c98c6f > div.e41894cca1 > div > div.a68bfa09c2 > a");

        if (isDisplayed(checkButton)) {
            waitUntilElementVisible(checkButton);
            click(checkButton);
        } else {
            waitUntilElementVisible(checkButton2);
            click(checkButton2);
        }

        Allure.addAttachment("Click on the first search result item", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Go to the newly opened tab")
    public void switchToTheNewTab() {
        switchTab();
        Allure.addAttachment("Go to the newly opened tab", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }
}
