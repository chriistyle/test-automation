package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressesPages {

    private WebDriver driver;
    public KeyPressesPages(WebDriver driver){
        this.driver = driver;
    }

    private By textField = By.id("target");
    private By resultText = By.id("result");

    public void enterText(String text){
        driver.findElement(textField).sendKeys(text);
    }

    public String getResultText(){
        return driver.findElement(resultText).getText();
    }


}
