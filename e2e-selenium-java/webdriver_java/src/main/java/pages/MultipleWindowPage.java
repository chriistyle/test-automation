package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowPage {

    private WebDriver driver;
    public MultipleWindowPage(WebDriver driver){
        this.driver = driver;
    }

    private By clickHereButton = By.linkText("Click Here");

    public void clickHere(){
        driver.findElement(clickHereButton).click();
    }
}
