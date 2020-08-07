package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private WebDriver driver;
    public FramesPage(WebDriver driver){
        this.driver = driver;
    }

    private By nestedFramesLink = By.linkText("Nested Frames");
    private By iFrameLink = By.linkText("iFrame");

    // no instantiation of a driver to the next class
    public NestedFramesPage clickNestedFramesLink(){
        driver.findElement(nestedFramesLink).click();
        return new NestedFramesPage(driver);
    }

}
