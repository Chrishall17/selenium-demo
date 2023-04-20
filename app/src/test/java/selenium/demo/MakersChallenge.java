package selenium.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class MakersChallenge {
    private static FirefoxDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
    }

    // Your tests will go here!
    @Test
    void endToEndTestOfMakers() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://makers.tech");
        WebElement cookies = driver.findElement(By.cssSelector("#cookie_action_close_header"));
        cookies.click();
        String makersTitle = driver.getTitle();
        assertTrue(makersTitle.contains("Change Your Life"));
        WebElement codeOfConduct = driver.findElement(By.linkText("Code of Conduct"));
        assertEquals("Code of Conduct", codeOfConduct.getText());
        codeOfConduct.click();
        String codeOfConductTitle = driver.getTitle();
        assertTrue(codeOfConductTitle.contains("Code of Conduct"));
        String URL = driver.getCurrentUrl();
        assertEquals("https://makers.tech/code-of-conduct/", URL);
        WebElement homepage = driver.findElement(By.cssSelector("#header > div > a"));
        homepage.click();
        WebElement FAQS = driver.findElement(By.cssSelector("#menu-item-1195 > a"));
        FAQS.click();
        String URL2 = driver.getCurrentUrl();
        assertEquals("https://faq.makers.tech/en/knowledge", URL2);
        WebElement searchBox = driver.findElement(By.cssSelector("body > header > div.kb-search-section.kb-search-section--full.kb-search-section-with-image > div > div > div.kb-search__box > div > form > input"));
        searchBox.sendKeys("badger");
        searchBox.sendKeys(Keys.ENTER);
        WebElement badgerResults = driver.findElement(By.cssSelector("#hsresults > p:nth-child(1)"));
        assertTrue(badgerResults.getText().contains("no search results for"));
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
