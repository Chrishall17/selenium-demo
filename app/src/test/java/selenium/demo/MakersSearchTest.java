package selenium.demo;

// in MakersSearchTest.java

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class MakersSearchTest {
    private static FirefoxDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void shouldFindSearchResultsForJava() {
//        driver.get("https://makers.tech/");
//        driver.findElement(By.linkText("FAQs")).click();
//        driver.findElement(By.cssSelector(".kb-search__bar .kb-search__input")).click();
//        driver.findElement(By.cssSelector(".kb-search__bar .kb-search__input")).sendKeys("java");
//        driver.findElement(By.cssSelector(".kb-search__bar .kb-search__input")).sendKeys(Keys.ENTER);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBe(By.cssSelector("h1"),"Results for"));
//        assertEquals("Results for", driver.findElement(By.cssSelector("h1")).getText());
        MakersSearchPage searchPage = new MakersSearchPage(driver);
        searchPage.navigate();
        searchPage.searchFor("java");
        searchPage.waitForResultsText("Results for");
        assertEquals("Results for", searchPage.getSearchResultsHeading());
    }

    @Test
    public void shouldNotFindSearchResultsForBadger() {
//        driver.get("https://makers.tech/");
//        driver.findElement(By.linkText("FAQs")).click();
//        driver.findElement(By.cssSelector(".kb-search__bar .kb-search__input")).click();
//        driver.findElement(By.cssSelector(".kb-search__bar .kb-search__input")).sendKeys("badger");
//        driver.findElement(By.cssSelector(".kb-search__bar .kb-search__input")).sendKeys(Keys.ENTER);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBe(By.cssSelector("h1"),"No results for"));
//        assertEquals("No results for", driver.findElement(By.cssSelector("h1")).getText());
        MakersSearchPage searchPage = new MakersSearchPage(driver);
        searchPage.navigate();
        searchPage.searchFor("badger");
        searchPage.waitForResultsText("No results for");
        assertEquals("No results for", searchPage.getSearchResultsHeading());
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
