package selenium.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class BrowserDisplays {
    private static WebDriver driver;
    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
    }

    @Test
    public void codeOfConductDisplayed() throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().setSize(new Dimension(1171, 802));
        driver.get("https://makers.tech");
        WebElement codeOfConduct = driver.findElement(By.linkText("Code of Conduct"));
        assertTrue(codeOfConduct.isDisplayed());
    }

    @Test
    public void codeOfConductDisplayedMobile() throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().setSize(new Dimension(390, 840));
        driver.get("https://makers.tech");
        List<WebElement> codeOfConduct = driver.findElements(By.linkText("Code of Conduct"));
        assertEquals(0, codeOfConduct.size());
    }


    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
