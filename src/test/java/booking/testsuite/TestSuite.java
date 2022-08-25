package booking.testsuite;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSuite {
    WebDriver wd;

    @BeforeClass
    public void setup() {
        wd = Utils.createDriverObj(2);
    }

    @Test
    @Epic("Website Flow")
    @Feature("Loading Website")
    @Story("Going to Register Page")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Visit Booking and Click Register")
    public void testCase1() {
        TestBookingHome tc1 = new TestBookingHome(wd);
        tc1.runTestcaseHomeScreen();
    }

    @Test
    @Epic("Registration Flow")
    @Feature("Registration Email Form")
    @Story("Test Multiple Error Cases")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Validate Registration Email Input")
    public void testCase2() {
        TestBookingRegister tc2 = new TestBookingRegister(wd);
        tc2.runTestcaseEmailScreen();
    }

    @Test
    @Epic("Registration Flow")
    @Feature("Registration Password Form")
    @Story("Test Multiple Error Cases")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Validate Registration Passwords Input")
    public void testCase3() {
        TestBookingRegister tc3 = new TestBookingRegister(wd);
        tc3.runTestCasePasswordScreen();
    }

    @Test
    @Epic("Search for Vacation Flow")
    @Feature("Search for Accommodation Form")
    @Story("Read From Excel File And Search With Predefined Params")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Enter Location Properties")
    public void testCase4() {
        TestBookingHome tc4 = new TestBookingHome(wd);
        tc4.runTestcaseLocationSearch();
    }

    @Test
    @Epic("Filter Search Results Flow")
    @Feature("Filter Accommodation Results")
    @Story("Show Only With Breakfast Included")
    @Severity(SeverityLevel.MINOR)
    @Description("Count and Filter Search Results")
    public void testCase5() {
        TestBookingResults tc5 = new TestBookingResults(wd);
        tc5.runTestcaseResultsScreen();
    }

    @Test
    @Epic("Reservation Flow")
    @Feature("Reservation Form")
    @Story("Make an Order")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Pick a room and make an order")
    public void testCase6() {
        TestBookingReservation tc6 = new TestBookingReservation(wd);
        tc6.runTestcaseReservationScreen();
    }


//    @AfterTest
//    public void Teardown() {
//        wd.quit();
//    }
}
