package selenium.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YoutubeTest {
    private static FirefoxDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
    }

    // Your tests will go here!
    @Test
    void shouldLoadHomepage() {
        driver.get("https://youtube.com");
        WebElement youtubeLukeCombs = driver.findElement(By.cssSelector("#media-container-link > #thumbnail-container"));
        System.out.println(youtubeLukeCombs.getText());
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
