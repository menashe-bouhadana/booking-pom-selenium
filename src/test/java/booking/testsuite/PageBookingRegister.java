package booking.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBookingRegister extends BaseMethods {
    public PageBookingRegister(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void testEmptyEmailField() {
        waitUntilElementClickable(By.cssSelector("button[type=submit]"));
        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);
    }

    public void testSpecialCharsEmailField() {
        typeInto(By.cssSelector("#username"), "#%*!2357392!@#*%&!@gmail.com");
        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);
    }

    public void clearEmailField() {
        removeInput(By.cssSelector("#username"));
    }

    public void testCorrectEmailField() {
        typeInto(By.cssSelector("#username"), "davidboeitheking@gmail.com");
        click(By.cssSelector("button[type=submit]"));
    }

    public void waitForPasswordScreenToLoad() {
        waitUntilElementVisible(By.cssSelector("#new_password"));
        if (isDisplayed(By.cssSelector("#new_password"))) {
            System.out.println("Switched to password confirmation step");
        }
    }

    public void testEmptyPasswordFileds() {
        waitUntilElementClickable(By.cssSelector("button[type=submit]"));
        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);
    }

    public void testOneCharPasswordFields() {
        typeInto(By.cssSelector("#new_password"), "A");
        typeInto(By.cssSelector("#confirmed_password"), "A");

        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);
    }

    public void clearPasswordFields() {
        removeInput(By.cssSelector("#new_password"));
        removeInput(By.cssSelector("#confirmed_password"));
    }

    public void testDifferentPasswordFields() {
        typeInto(By.cssSelector("#new_password"), "Abc10203040");
        typeInto(By.cssSelector("#confirmed_password"), "Abc50607090");

        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);
    }

    public void testCorrectPasswordFields() {
        typeInto(By.cssSelector("#new_password"), "Abc10203040");
        typeInto(By.cssSelector("#confirmed_password"), "Abc10203040");

        click(By.cssSelector("button[type=submit]"));
    }

    public void becauseOfValidationGoToHome() {
        visit("https://booking.com/");
    }
}
