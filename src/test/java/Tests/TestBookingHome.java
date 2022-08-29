package Tests;

import Pages.PageBookingHome;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class TestBookingHome {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestBookingHome(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void runTestcaseHomeScreen() {
        PageBookingHome page = new PageBookingHome(driver, wait);
        page.visitBooking();
        page.clickOnRegister();
    }

    public void runTestcaseLocationSearch() {
        PageBookingHome page = new PageBookingHome(driver, wait);
        page.waitForLocationFieldToBeVisible();
        page.readFromCSVAndTypeIntoSearchField();
        page.countLocationResults();
        page.clickOnTheFirstResult();
        page.clickAndPickVacationDates();
        page.clickSubmitBtn();
    }
}
