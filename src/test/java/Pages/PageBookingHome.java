package Pages;

import SeleniumHelper.BaseMethods;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }

    @Step("Click on the register button")
    public void clickOnRegister() {
        waitUntilElementVisible(By.cssSelector(".js-header-login-link:first-of-type"));
        click(By.cssSelector(".js-header-login-link:first-of-type"));
    }

    public void waitForLocationFieldToBeVisible() {
        waitUntilElementVisible(By.cssSelector(".sb-destination__input"));
    }

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
    }

    public void countLocationResults() {
        waitUntilElementVisible(By.cssSelector(".search_hl_name"));
        List<WebElement> lst = findMultipleElements(By.cssSelector(".search_hl_name"));

        for (WebElement curr : lst) {
            System.out.println("Search Result Appeared: " + curr.getText());
        }
    }

    public void clickOnTheFirstResult() {
        waitUntilElementVisible(By.cssSelector(".search_hl_name"));
        click(By.cssSelector(".search_hl_name:first-of-type"));
    }

    public void clickAndPickVacationDates() {

        WebElement vacationStart = findElement(By.cssSelector(".bui-calendar__date span[aria-label=\"15 September 2022\"]"));
        WebElement vacationEnd = findElement(By.cssSelector(".bui-calendar__date span[aria-label=\"22 September 2022\"]"));

        vacationStart.click();
        vacationEnd.click();
    }

    public void clickSubmitBtn() {
        click(By.cssSelector(".sb-searchbox__button"));
    }

}
