package selenium.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TodoTest {
    private static FirefoxDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
    }

    // Your tests will go here!
    @Test
    void shouldLoadHomepage() {
        driver.get("https://todomvc.com");
    }

    @Test
    void viewOnGithub() {
        driver.get("https://todomvc.com");
        WebElement githubButton = driver.findElement(By.linkText("View on GitHub"));
        System.out.println(githubButton.getText());
    }

    @Test
    void viewOnJavascript() {
        driver.get("https://todomvc.com/");
        WebElement javaScriptTab = driver.findElement(By.cssSelector(".x-scope:nth-child(1) > .tab-content"));
        System.out.println(javaScriptTab.getText());
        javaScriptTab.click();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
