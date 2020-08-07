package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    private By dropdown = By.id("dropdown");


    // will select the dropdown based on the parameter
    public void selectFromDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public void selectMultipleOptions(List<String> options){
        for(String option: options ){
            findDropdownElement().selectByVisibleText(option);
        }
    }

    public List<String> getSelectedOption(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();

        // BUT ".getAllSelectedOptions()" returns "list<WebElement>"
        // Convert list<WebElements> to list<String>

        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropdownElement(){
        return new Select((driver.findElement(dropdown)));
    }

    public void addMultipleAttOnDropdown(){
        WebElement dropdownElement = driver.findElement(dropdown);
        String script = "arguments[0].setAttribute('multiple', '')";

        // NOTE: You need to convert BY locator to WebElement
        // so that you can use it on the jsExecutor(script, object)
        ((JavascriptExecutor)driver).executeScript(script,dropdownElement);
    }
}
