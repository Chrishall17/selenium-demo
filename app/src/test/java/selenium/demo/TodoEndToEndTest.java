package selenium.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TodoEndToEndTest {
    private static FirefoxDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
    }

    // Your tests will go here!
    @Test
    void endToEndTestOfTodo() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://todomvc.com");
        WebElement reactPage = driver.findElement(By.linkText("React"));
        reactPage.click();
        String reactTitle = driver.getTitle();
        assertEquals("React • TodoMVC", reactTitle);
        WebElement todoBar = driver.findElement(By.cssSelector(".new-todo"));
        todoBar.click();
        todoBar.sendKeys("Buy some milk");
        todoBar.sendKeys(Keys.ENTER);
        WebElement itemAdded = driver.findElement(By.cssSelector("body > section > div > section > ul > li > div > label"));
        assertEquals("Buy some milk", itemAdded.getText());
        WebElement itemMessage = driver.findElement(By.cssSelector("body > section > div > footer > span"));
        assertEquals("1 item left", itemMessage.getText());
        driver.findElement(By.cssSelector(".toggle")).click();
        WebElement itemMessage2 = driver.findElement(By.cssSelector("body > section > div > footer > span"));
        assertEquals("0 items left", itemMessage2.getText());
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
