package booking.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBookingResults extends BaseMethods {
    public PageBookingResults(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForResultsToLoad() {
        waitUntilElementVisible(By.cssSelector(".d3a14d00da"));
    }

    public void countForSearchResults() {
        String resultCount = getTextByLocator(By.cssSelector(".d3a14d00da"));
        System.out.println(resultCount);
    }

    public void checkboxBreakfastIncluded() {
        waitUntilElementVisible(By.cssSelector("div[data-filters-item=\"popular:mealplan=1\"]"));
        click(By.cssSelector("div[data-filters-item=\"popular:mealplan=1\"]"));
    }

    public void checkAvailabilityForFirstResult() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(By.cssSelector("div:nth-child(3) > div.d20f4628d0 > div.b978843432 > div > div.a1b3f50dcd.b2fe1a41c3.a7c67ebfe5.d19ba76520.d14b211b4f > div.b1e6dd8416 > div > div:nth-child(1) > div > h3 > a"));
    }

    public void switchToTheNewTab() {
        switchTab();
    }
}
