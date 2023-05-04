package selenium.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TimezoneTest {
        private static WebDriver driver;
        @BeforeAll
        static void launchBrowser() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver();
        }

        @Test
        public void timezone() throws Exception {
            driver.get("https://everytimezone.com/");
            takeScreenshot(driver, "src/test/my_timezone.png");

            // Create a DevTools session, add the timezone override, and apply changes
            DevTools devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();
            Map<String, Object> map = new HashMap<>();
            map.put("timezoneId", "America/New_York");
            ((ChromeDriver)driver).executeCdpCommand("Emulation.setTimezoneOverride", map);

            // Reload the page, and take a screenshot with the new timezone settings
            driver.get("https://everytimezone.com/");
            takeScreenshot(driver, "src/test/other_timezone.png");
        }

        public static void takeScreenshot(WebDriver webdriver, String desiredPath) throws Exception{
            TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
            File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
            File targetFile = new File(desiredPath);
            FileUtils.copyFile(screenshotFile, targetFile);
        }

        @AfterAll
        static void closeBrowser() {
            driver.quit();
        }
    }
