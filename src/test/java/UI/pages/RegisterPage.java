package UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By nameField = By.id("input-name-register");
    private final By emailField = By.id("input-email-register");
    private final By registerButton = By.id("btn-register");
    private final By emailErrorMessage = By.id("Something-Went-Wrong!");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(nameField)).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated (emailField)).sendKeys(email);
    }

    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public String getEmailErrorMessage() {
        return driver.findElement(emailErrorMessage).getText();
        }
}
