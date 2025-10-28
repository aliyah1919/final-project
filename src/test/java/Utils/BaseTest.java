package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        ConfigReader.loadProperties();
        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.get("base.url"));
        System.out.println("🚀 Browser launched and navigated to base URL");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            System.out.println("🧹 Closing browser...");
            driver.quit();
        }
    }
}
