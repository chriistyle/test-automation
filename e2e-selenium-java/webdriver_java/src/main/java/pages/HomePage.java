package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdownLink(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHoverPageLink(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public ForgotPasswordPage clickForgotPasswordLink(){
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public KeyPressesPages clickKeyPressesLink(){
        clickLink("Key Presses");
        return new KeyPressesPages(driver);
    }

    public HorizontalSliderPage clickHorizontalSliderLink(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public JavascriptAlertsPage clickJavascriptAlertsLink(){
        clickLink("JavaScript Alerts");
        return new JavascriptAlertsPage(driver);
    }

    public FileUploadPage clickFileUploadLink(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WYSIWYGPage clickWYSIWYGLink(){
        clickLink("WYSIWYG Editor");
        return new WYSIWYGPage(driver);
    }

    public FramesPage clickFramesLink() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingLink(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDOM clickLargeAndDeeoDOMLink(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDOM(driver);
    }

    public InfiniteScrollPage clickInfiniteScrollLink(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowPage clickMultipleWindowLink(){
        clickLink("Multiple Windows");
        return new MultipleWindowPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
