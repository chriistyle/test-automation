package upload;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UploadAFileTests extends BaseTests {

    @Test
    public void uploadAFile(){
        var uploadPage = homePage.clickFileUploadLink();
        uploadPage.clickFileUpload("C:\\Users\\Chris\\Documents\\test-automation\\e2e-selenium-java\\webdriver_java\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getStatusText(),"File Uploaded!","Status Text incorrect");
        assertEquals(uploadPage.getUploadedFileText(),"chromedriver.exe","file name incorrect");
    }
}
