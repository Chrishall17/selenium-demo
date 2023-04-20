package selenium.demo;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class GovUKTest {
    private static FirefoxDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
    }

    // Your tests will go here!
    @Test
    void interactingWithGovUKForCarTax() throws Exception {
        driver.get("https://www.gov.uk/");
        WebElement cookies = driver.findElement(By.cssSelector(".gem-c-button:nth-child(1)"));
        cookies.click();
        WebElement findSearch = driver.findElement(By.xpath("//div[2]/form/div/div/input"));
        findSearch.click();
        // 4 | type | id=search-main-206d7ca9 | car tax
        WebElement typeCarTax = driver.findElement(By.xpath("//div[2]/form/div/div/input"));
        typeCarTax.sendKeys("car tax");
        // 5 | click | css=.govuk-\!-margin-bottom-0 .gem-c-search__submit |
        WebElement clickSearch = driver.findElement(By.xpath("//div[2]/form/div/div/div/button"));
        clickSearch.click();
        // 6 | click | linkText=Tax your vehicle |
        WebElement clickTaxYourVehicle = driver.findElement(By.linkText("Tax your vehicle"));
        clickTaxYourVehicle.click();
        takeScreenshot(driver, "src/test/tax.png");
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