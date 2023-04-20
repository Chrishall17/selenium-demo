package selenium.demo;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class TodoDebuggingTest {
    private static FirefoxDriver driver;
    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
    }
    // Your tests will go here!
    @Test
    void shouldClickOnReact() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        driver.get("https://todomvc.com/");
        WebElement clickReact = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(By.linkText("React")));
        clickReact.click();
//        WebElement clickReact = driver.findElement(By.linkText("React"));
//        clickReact.click();

        WebElement clickNewTodo = driver.findElement(By.cssSelector(".new-todo"));
        clickNewTodo.click();

        WebElement typeNewTodo = driver.findElement(By.cssSelector(".new-todo"));
        typeNewTodo.sendKeys("scream");

        WebElement enterNewTodo = driver.findElement(By.cssSelector(".new-todo"));
        enterNewTodo.sendKeys(Keys.ENTER);

//        Thread.sleep(3000);

        WebElement markTodoComplete = driver.findElement(By.cssSelector(".toggle"));
        markTodoComplete.click();

//        driver.findElement(By.tagName("body"));
        WebElement clearTodo = driver.findElement(By.cssSelector(".clear-completed"));
        clearTodo.click();

    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
