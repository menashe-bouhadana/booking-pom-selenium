package Tests;

import Pages.PageBookingResults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBookingResults {

    private WebDriver driver;
    private WebDriverWait wait;

    public TestBookingResults(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void runTestcaseResultsScreen() {
        PageBookingResults page = new PageBookingResults(driver, wait);
        page.waitForResultsToLoad();
        page.countForSearchResults();
        page.checkboxBreakfastIncluded();
        page.waitForResultsToLoad();
        page.countForSearchResults();
        page.checkAvailabilityForFirstResult();
        page.switchToTheNewTab();
    }
}
