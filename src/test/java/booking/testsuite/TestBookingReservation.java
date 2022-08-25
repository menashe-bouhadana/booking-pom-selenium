package booking.testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBookingReservation {

    private WebDriver driver;
    private WebDriverWait wait;

    public TestBookingReservation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void runTestcaseReservationScreen() {
        PageBookingReservation page = new PageBookingReservation(driver, wait);
        page.selectRoomsFromDropDown();
        page.clickReserve();
    }


}
