package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import javax.sound.midi.SysexMessage;

public class InfiniteScrollPage {

    private WebDriver driver;

    // Setter
    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    private By textBlock = By.className("jscroll-added");

    /**
     * Scrolls until paragraph with index specified is in view
     * @param index 1-based
     */
    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor) driver;

        // getParagraphSize() -> 2
        while (getParagraphSize() < index) {
            jsExecutor.executeScript(script);
        }
    }

    private int getParagraphSize(){
        int count = driver.findElements(textBlock).size();
        System.out.println(">>>> COUNT "+count);
        return count;
    }
}
