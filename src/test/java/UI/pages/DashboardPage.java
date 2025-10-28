package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    // Locators
    private By createTicketButton = By.id("btn-create-ticket");
    private By userProfileButton = By.id("btn-profile");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateTicket() {
        driver.findElement(createTicketButton).click();
    }

    public boolean isDashboardDisplayed() {
        return driver.findElement(userProfileButton).isDisplayed();
    }
}
