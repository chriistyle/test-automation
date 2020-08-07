package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class DynamicLoadingPage {

    private WebDriver driver;
    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    private String linkXpath_Format = ".//a[contains(text(),'%s')]";
    private By link_Example1 = By.xpath(String.format(linkXpath_Format, "Example 1"));
    private By link_Example2 = By.xpath(String.format(linkXpath_Format, "Example 2"));


    public DynamicLoadingPage_Example1 clickExample1Link(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingPage_Example1(driver);
    }

    public DynamicLoadingPage_Example2 clickExample2Link(){
        driver.findElement(link_Example2).click();
        return new DynamicLoadingPage_Example2(driver);
    }

    public DynamicLoadingPage_Example2 openExample2InNewTab(){
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click(driver.findElement(link_Example2))
                .keyUp(Keys.CONTROL).perform();
        return new DynamicLoadingPage_Example2(driver);
    }
}
