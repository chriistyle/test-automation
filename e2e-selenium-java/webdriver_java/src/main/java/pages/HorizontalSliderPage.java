package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    private By slider = By.tagName("input");
    private By slideCount = By.cssSelector("span#range");

    public void clickSlider(){
        driver.findElement(slider).click();
    }

    public void moveSlider(int count){
        for(int i = 1; count > i; i++){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderCount(){
        return driver.findElement(slideCount).getText();
    }
}
