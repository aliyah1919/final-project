package UI.tests;

import UI.pages.CreateTicketPage;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.DashboardPage;

public class TicketUITest extends BaseTest {

    @Test
    public void testCreateTicket() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickCreateTicket();

        CreateTicketPage ticketPage = new CreateTicketPage(driver);
        ticketPage.enterTitle("Test Ticket");
        ticketPage.enterDescription("This is a test ticket from automation.");
        ticketPage.clickSubmit();

        String message = ticketPage.getSuccessMessage();
        Assert.assertTrue(message.contains("Berhasil membuat tiket") || message.contains("Ticket created successfully"),
                "Success message should appear");
    }
}
