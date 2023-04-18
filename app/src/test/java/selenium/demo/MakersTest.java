package selenium.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MakersTest {
    private static FirefoxDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
    }

    // Your tests will go here!
    @Test
    public void shouldPrintPageTitle() {
        driver.get("https://makers.tech");
        System.out.println(driver.getTitle());
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }


}
