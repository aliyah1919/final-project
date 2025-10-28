package UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTicketPage {
    private WebDriver driver;

    // Locators
    private By titleField = By.id("input-title-ticket");
    private By descriptionField = By.id("input-description-ticket");
    private By submitButton = By.id("btn-submit-ticket");
    private By successMessage = By.xpath("//*[contains(text(),'Ticket created successfully') or contains(text(),'Berhasil membuat tiket')]");

    public CreateTicketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTitle(String title) {
        driver.findElement(titleField).clear();
        driver.findElement(titleField).sendKeys(title);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionField).clear();
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
