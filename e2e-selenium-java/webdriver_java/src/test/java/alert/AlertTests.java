package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void acceptAlertTests(){
        var alertsPage = homePage.clickJavascriptAlertsLink();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You successfuly clicked an alert","Result Text incorrect");
    }

    @Test
    public void dismissAlertTests(){
        var alertsPage = homePage.clickJavascriptAlertsLink();
        alertsPage.triggerConfirm();
        assertEquals(alertsPage.alert_getText(),"I am a JS Confirm","Alert Text incorrect");
        alertsPage.alert_clickToDismiss();
        assertEquals(alertsPage.getResult(),"You clicked: Cancel","Result Text incorrect");
    }

    @Test
    public void enterTextAlertTests(){
        var alertsPage = homePage.clickJavascriptAlertsLink();
        alertsPage.triggerPrompt();
        String text = "Test Automation Rocks!!!";
        alertsPage.alert_enterText(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You entered: "+text,"Result Text Incorrect");

    }
}
