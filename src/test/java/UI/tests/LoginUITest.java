package UI.tests;

import UI.pages.LoginPage;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.DashboardPage;

public class LoginUITest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("aliyahnafilah19@gmail.com");
        loginPage.enterPassword("Naktaubae19");
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "User should be redirected to dashboard");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("aliyahnafilah19@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }
}
