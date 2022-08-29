package Pages;

import SeleniumHelper.BaseMethods;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PageBookingHome extends BaseMethods {

    String CSVFile = "/Users/menashbouhadana/IdeaProjects/BaseForProjectGmar/src/test/java/Databases/bookingData.csv";
    String[] csvCell;
    private CSVReader csvReader;

    public PageBookingHome(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Go to booking.com")
    public void visitBooking() {
        visit("https://booking.com");
        Allure.addAttachment("Go to booking.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click on the register button")
    public void clickOnRegister() {
        waitUntilElementVisible(By.cssSelector(".js-header-login-link:first-of-type"));
        click(By.cssSelector(".js-header-login-link:first-of-type"));
        Allure.addAttachment("Click on the register button", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Wait for search input to be visible")
    public void waitForLocationFieldToBeVisible() {
        waitUntilElementVisible(By.cssSelector(".sb-destination__input"));

        Allure.addAttachment("Wait for search input to be visible", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Read from CSV file and Type into Search Field")
    public void readFromCSVAndTypeIntoSearchField() {
        try {
            csvReader = new CSVReader(new FileReader(CSVFile));

            while ((csvCell = csvReader.readNext()) != null) {
                String LocationName = csvCell[0];

                typeInto(By.cssSelector(".sb-destination__input"), LocationName);

                System.out.println("Fetched Location from CSV: " + LocationName);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        Allure.addAttachment("Read from CSV file and Type into Search Field", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Print location search results")
    public void countLocationResults() {
        waitUntilElementVisible(By.cssSelector(".search_hl_name"));
        List<WebElement> lst = findMultipleElements(By.cssSelector(".search_hl_name"));

        for (WebElement curr : lst) {
            System.out.println("Search Result Appeared: " + curr.getText());
        }

        Allure.addAttachment("Print location search results", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click on the first result")
    public void clickOnTheFirstResult() {
        waitUntilElementVisible(By.cssSelector(".search_hl_name"));
        click(By.cssSelector(".search_hl_name:first-of-type"));

        Allure.addAttachment("Click on the first result", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click and pick vacation dates")
    public void clickAndPickVacationDates() {

        WebElement vacationStart = findElement(By.cssSelector(".bui-calendar__date span[aria-label=\"15 September 2022\"]"));
        WebElement vacationEnd = findElement(By.cssSelector(".bui-calendar__date span[aria-label=\"22 September 2022\"]"));

        vacationStart.click();
        vacationEnd.click();
        Allure.addAttachment("Click and pick vacation dates", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click the search submit button")
    public void clickSubmitBtn() {
        click(By.cssSelector(".sb-searchbox__button"));
        Allure.addAttachment("Click the search submit button", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }


}
