package booking.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBookingReservation extends BaseMethods {
    public PageBookingReservation(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void selectRoomsFromDropDown() {
        selectFromDropDownListByValue(By.name("nr_rooms_bbasic_"), "1");

        String roomCost = getTextByLocator(By.cssSelector(".hprt-reservation-total-price"));

        System.out.println("Room Cost: " + roomCost);
    }

    public void clickReserve() {
        click(By.cssSelector(".js-reservation-button"));
    }
}
