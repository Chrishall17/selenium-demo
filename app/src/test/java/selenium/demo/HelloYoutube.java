package selenium.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloYoutube {
    public static void main(String[] args) throws Exception{

        // Create a new instance of Selenium
//        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        // Allow the ChromeDriver to accept remote connections
        // Workaround for an issue which will be fixed in WebDriver 4.9.0:
        // https://github.com/SeleniumHQ/selenium/issues/11750
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Use WebDriver to open a new instance of Chrome
//        WebDriver driver = new ChromeDriver(options);
        WebDriver driver = new FirefoxDriver();

        // Instruct the driver to browse to the Makers website
        driver.get("https://www.youtube.com/watch?v=aoJwvnDuAR0&list=RDQMhGYSAmDL8fE&index=27");

        // Take a screenshot of what's currently on the page,
        // and store it in a file called 'makers.png'
        takeScreenshot(driver, "src/test/youtube.png");

        // Find the title of the webpage (the value inside the HTML
        // <title> element) and print it to the terminal
        System.out.println(driver.getTitle());

        // Close down Selenium and end the test
        driver.quit();
    }

    // Helper function for taking screenshots using WebDriver
    public static void takeScreenshot(WebDriver webdriver,String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}
