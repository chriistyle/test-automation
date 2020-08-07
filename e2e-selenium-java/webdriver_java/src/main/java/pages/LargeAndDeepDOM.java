package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDOM {

    private WebDriver driver;
    public LargeAndDeepDOM(WebDriver driver){
        this.driver = driver;
    }

    private By largeTable = By.id("large-table");

    public void  scrollToTable(){
        WebElement tableElement = driver.findElement(largeTable);

        // will make a variable string
        // arguments[0] is a placeholder cos we cannot use WebElement to this string variable
        String script = "arguments[0].scrollIntoView();";

        // <javascript executor casting form with driver>.executeScript(<script on string>,<object/element until where to scroll>)
        ((JavascriptExecutor)driver).executeScript(script,tableElement);
    }
}
