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

public class PageBookingReservation extends BaseMethods {
    public PageBookingReservation(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Select amount of rooms from the dropdown")
    public void selectRoomsFromDropDown() {
        waitUntilElementVisible(By.cssSelector("#hprt-table > tbody > tr:nth-child(1) > td.hprt-table-cell.hprt-table-room-select > div > select"));
        selectFromDropDownListByValue(By.cssSelector("#hprt-table > tbody > tr:nth-child(1) > td.hprt-table-cell.hprt-table-room-select > div > select"), "1");

        String roomCost = getTextByLocator(By.cssSelector(".hprt-reservation-total-price"));

        System.out.println("Room Cost: " + roomCost);

        Allure.addAttachment("Room Cost: " + roomCost, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click reserve button")
    public void clickReserve() {
        click(By.cssSelector(".js-reservation-button"));
        Allure.addAttachment("Click reserve button", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
