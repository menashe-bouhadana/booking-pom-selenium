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
        By checkButton = By.cssSelector("div:nth-child(3) > div.d20f4628d0 > div.b978843432 > div > div.a1b3f50dcd.b2fe1a41c3.a7c67ebfe5.d19ba76520.d14b211b4f > div.b1e6dd8416 > div > div:nth-child(1) > div > h3 > a");
        waitUntilElementVisible(checkButton);
        click(checkButton);
        Allure.addAttachment("Click on the first search result item", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Go to the newly opened tab")
    public void switchToTheNewTab() {
        switchTab();
        Allure.addAttachment("Go to the newly opened tab", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }
}
