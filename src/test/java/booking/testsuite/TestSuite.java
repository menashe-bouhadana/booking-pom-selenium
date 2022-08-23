package booking.testsuite;

import io.qameta.allure.Description;
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
    @Description("Visit Booking and Click Register")
    public void testCase1() {
        TestBookingHome tc1 = new TestBookingHome(wd);
        tc1.runTestcaseHomeScreen();
    }

    @Test
    @Description("Validate Registration Email Input")
    public void testCase2() {
        TestBookingRegister tc2 = new TestBookingRegister(wd);
        tc2.runTestcaseEmailScreen();
    }

    @Test
    @Description("Validate Registration Passwords Input")
    public void testCase3() {
        TestBookingRegister tc3 = new TestBookingRegister(wd);
        tc3.runTestCasePasswordScreen();
    }

    @Test
    @Description("Enter Location Properties")
    public void testCase4() {
        TestBookingHome tc4 = new TestBookingHome(wd);
        tc4.runTestcaseLocationSearch();
    }

    @AfterTest
    public void Teardown() {
        wd.quit();
    }
}
