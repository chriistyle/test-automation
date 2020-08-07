package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    private By fileUploadButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadStatus = By.tagName("h3");
    private By uploadedFileName = By.id("uploaded-files");

    public void clickFileUpload(String absoluteFilePath){
        driver.findElement(fileUploadButton).sendKeys(absoluteFilePath);
        uploadAFile();
    }

    public void uploadAFile(){
        driver.findElement(uploadButton).click();
    }

    public String getStatusText(){
        return driver.findElement(uploadStatus).getText();
    }

    public String getUploadedFileText(){
        return driver.findElement(uploadedFileName).getText();
    }
}
