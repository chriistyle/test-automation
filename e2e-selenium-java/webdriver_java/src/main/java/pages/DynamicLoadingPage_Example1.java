package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage_Example1 {

    private WebDriver driver;

    public DynamicLoadingPage_Example1(WebDriver driver) {
        this.driver = driver;
    }

    private By startButton = By.cssSelector("#start button");
    private By loadingBar = By.id("loading");
    private By text = By.id("finish");

    public void clickStart() {
        driver.findElement(startButton).click();

        // Explicit Wait
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));

        // Fluent Wait
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofNanos(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));

    }

    public String getText(){
        return driver.findElement(text).getText();
    }
}
