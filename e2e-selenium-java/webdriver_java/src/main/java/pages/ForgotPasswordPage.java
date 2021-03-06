package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailAddressField = By.id("email");
    private By retrievePasswordButton = By.cssSelector("#forgot_password button");

    public void setEmailAddress(String email){
        driver.findElement(emailAddressField).sendKeys(email);
    }

    public EmailSentPage clickRetrievePassword(){
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentPage(driver);
    }
}
