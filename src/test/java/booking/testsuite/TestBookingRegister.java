package booking.testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBookingRegister {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestBookingRegister(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void runTestcaseEmailScreen() {
        PageBookingRegister page = new PageBookingRegister(driver, wait);

        page.testEmptyEmailField();
        page.testSpecialCharsEmailField();
        page.clearEmailField();
        page.testCorrectEmailField();
    }

    public void runTestCasePasswordScreen() {
        PageBookingRegister page = new PageBookingRegister(driver, wait);

        page.waitForPasswordScreenToLoad();
        page.testEmptyPasswordFileds();
        page.testOneCharPasswordFields();
        page.clearPasswordFields();
        page.testDifferentPasswordFields();
        page.clearPasswordFields();
        page.testCorrectPasswordFields();
        page.becauseOfValidationGoToHome();
    }
}
