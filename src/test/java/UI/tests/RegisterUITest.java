package UI.tests;

import Utils.BaseTest;
import UI.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegisterUITest extends BaseTest {

    @Test
    public void testValidRegister() {
        driver.get("https://resonance.dibimbing.id/register");

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterName("Aliyah");
        registerPage.enterEmail("aliyahnafilah19@gmail.com");
        registerPage.clickRegister();

        // ✅ Tunggu pesan sukses muncul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Berhasil Membuat User')]"))
        ).getText();

        // ✅ Verifikasi pesan sesuai
        Assert.assertTrue(successMessage.contains("Berhasil Membuat User"),
                "Expected success message not found. Actual: " + successMessage);

        System.out.println("Register berhasil - pesan sukses muncul");
    }
    @Test
    public void testInvalidEmailFormat() {
        driver.get("https://resonance.dibimbing.id/register");

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterName("Aliyah");
        registerPage.enterEmail("Aliyah@yahoo.id"); // invalid email
        registerPage.clickRegister();

        // Tunggu error message muncul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Something Went Wrong!')]"))
        );

        // Ambil text error dan verifikasi
        String actualError = registerPage.getEmailErrorMessage();
        Assert.assertEquals(actualError, "Invalid email format",
                "Expected error message not found. Actual: " + actualError);

        System.out.println("Test Passed - pesan invalid akan muncul");
    }

}
