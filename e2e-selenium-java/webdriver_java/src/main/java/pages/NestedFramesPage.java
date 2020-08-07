package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage {

    private WebDriver driver;
    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By bodyElement = By.tagName("body");

    private void switchToTopArea(){
        driver.switchTo().frame(topFrame);
    }

    private void switchToLeftArea(){
        driver.switchTo().frame(leftFrame);
    }

    private void switchToBottomArea(){
        driver.switchTo().frame(bottomFrame);
    }

    /**
     * not necessarily returns to main frame. it only increments one frame.
     */
    private void returnToTopFrame(){
        driver.switchTo().parentFrame();
    }

    public String getLeftAreaText(){
        switchToTopArea();
        switchToLeftArea();
        String text = driver.findElement(bodyElement).getText();
        returnToTopFrame(); // From Left Frame to Top Frame
        returnToTopFrame(); // From Top Frame to Main frame
        return text;
    }

    public String getBottomAreaText(){
        switchToBottomArea();
        String text = driver.findElement(bodyElement).getText();
        System.out.println(text);
        returnToTopFrame(); // From Bottom Frame to Main Frame
        return text;
    }
}
