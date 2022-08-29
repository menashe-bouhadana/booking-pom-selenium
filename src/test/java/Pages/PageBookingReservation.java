package Pages;

import SeleniumHelper.BaseMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBookingReservation extends BaseMethods {
    public PageBookingReservation(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Select amount of rooms from the dropdown")
    public void selectRoomsFromDropDown() {
        waitUntilElementVisible(By.cssSelector("#hprt_nos_select_18579605_131368017_2_41_0"));
        selectFromDropDownListByValue(By.cssSelector("#hprt_nos_select_18579605_131368017_2_41_0"), "1");

        String roomCost = getTextByLocator(By.cssSelector(".hprt-reservation-total-price"));

        System.out.println("Room Cost: " + roomCost);
    }

    @Step("Click reserve button")
    public void clickReserve() {
        click(By.cssSelector(".js-reservation-button"));
    }
}
