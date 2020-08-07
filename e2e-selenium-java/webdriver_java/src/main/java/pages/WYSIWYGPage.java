package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WYSIWYGPage {

    private WebDriver driver;
    public WYSIWYGPage(WebDriver driver){
        this.driver = driver;
    }

    // .frame(<String>)
    private String editorIFrameId = "mce_0_ifr";
    private By inputField = By.id("tinymce");
    private By increaseIndentButton = By.cssSelector("#mceu_12 button");

    // .frame(WebElement)
//     private By editorAreaBox = By.id("mce_0_ifr");
//     WebElement editorAreaElement = driver.findElement(editorAreaBox);

    private void switchToEditArea(){
        // switches the focus on the editor only
        // .frame accepts
        // a) String
        driver.switchTo().frame(editorIFrameId);

        // b) WebElement
//         driver.switchTo().frame(editorAreaElement);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    /**
     * Make sure to exit iFrame after you used
     */

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(inputField).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(inputField).sendKeys(text);
        switchToMainArea();
    }

    public void increaseIndention(){
        driver.findElement(increaseIndentButton).click();
    }

    public String getText(){
        switchToEditArea();
        String text = driver.findElement(inputField).getText();
        switchToMainArea();
        return text;
    }
}
