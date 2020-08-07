package forgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setEmailAddress("christopher@google.com");
        var emailSentPage = forgotPasswordPage.clickRetrievePassword();
        assertTrue(emailSentPage.getAlertText().contains("Your e-mail's been sent!"),"Alert is incorrect");
    }
}
