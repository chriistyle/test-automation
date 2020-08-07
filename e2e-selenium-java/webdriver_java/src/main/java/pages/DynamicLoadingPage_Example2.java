package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage_Example2 {

    private WebDriver driver;
    public DynamicLoadingPage_Example2(WebDriver driver){
        this.driver = driver;
    }

    private By startButton = By.cssSelector("#start button");
    private By text = By.id("finish");

    public void clickStart(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.presenceOfElementLocated(text));
        wait.until(ExpectedConditions.presenceOfElementLocated(text));

    }

    public boolean isStartButtonDisplayed(){
        return driver.findElement(startButton).isDisplayed();
    }

    public String getText(){
        return driver.findElement(text).getText();
    }
}
