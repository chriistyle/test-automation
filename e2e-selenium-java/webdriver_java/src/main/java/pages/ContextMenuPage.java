package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

import java.awt.event.MouseEvent;


public class ContextMenuPage {

    private WebDriver driver;

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    private By hotspotBox = By.id("hot-spot");

    public void clickHotSpot(){
        WebElement box = driver.findElement(hotspotBox);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    public void acceptAlertButton(){
        driver.switchTo().alert().accept();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }


}
