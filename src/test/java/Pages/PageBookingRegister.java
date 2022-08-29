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

public class PageBookingRegister extends BaseMethods {
    public PageBookingRegister(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Test email input field with empty input")
    public void testEmptyEmailField() {
        waitUntilElementClickable(By.cssSelector("button[type=submit]"));
        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);

        Allure.addAttachment(ErrorMessage, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Test email input field with special chars input")
    public void testSpecialCharsEmailField() {
        typeInto(By.cssSelector("#username"), "#%*!2357392!@#*%&!@gmail.com");
        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);
        Allure.addAttachment(ErrorMessage, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Clear input from email field")
    public void clearEmailField() {
        removeInput(By.cssSelector("#username"));
        Allure.addAttachment("Clear input from email field", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Test email input field with correct input")
    public void testCorrectEmailField() {
        typeInto(By.cssSelector("#username"), "davidboeitheking@gmail.com");
        click(By.cssSelector("button[type=submit]"));
        Allure.addAttachment("Test email input field with correct input", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Wait for the password step to load")
    public void waitForPasswordScreenToLoad() {
        waitUntilElementVisible(By.cssSelector("#new_password"));
        if (isDisplayed(By.cssSelector("#new_password"))) {
            System.out.println("Switched to password confirmation step");
        }
        Allure.addAttachment("Wait for the password step to load", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Test password input fields with empty input")
    public void testEmptyPasswordFileds() {
        waitUntilElementClickable(By.cssSelector("button[type=submit]"));
        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);
        Allure.addAttachment(ErrorMessage, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Test password input fields with one char input")
    public void testOneCharPasswordFields() {
        typeInto(By.cssSelector("#new_password"), "A");
        typeInto(By.cssSelector("#confirmed_password"), "A");

        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);

        Allure.addAttachment(ErrorMessage, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Clear password input fields")
    public void clearPasswordFields() {
        removeInput(By.cssSelector("#new_password"));
        removeInput(By.cssSelector("#confirmed_password"));
        Allure.addAttachment("Clear password input fields", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Test password input fields with different inputs")
    public void testDifferentPasswordFields() {
        typeInto(By.cssSelector("#new_password"), "Abc10203040");
        typeInto(By.cssSelector("#confirmed_password"), "Abc50607090");

        click(By.cssSelector("button[type=submit]"));

        String ErrorMessage = getTextByLocator(By.cssSelector(".fD2Lif3G4ehCgKZJDFwf"));
        System.out.println(ErrorMessage);

        Allure.addAttachment(ErrorMessage, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Test password input fields with correct input")
    public void testCorrectPasswordFields() {
        typeInto(By.cssSelector("#new_password"), "Abc10203040");
        typeInto(By.cssSelector("#confirmed_password"), "Abc10203040");

        click(By.cssSelector("button[type=submit]"));

        Allure.addAttachment("Test password input fields with correct input", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Back to homepage")
    public void becauseOfValidationGoToHome() {
        System.out.println("Registration Successes, Going back home");
        visit("https://booking.com/");

        Allure.addAttachment("Back to homepage", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }
}
