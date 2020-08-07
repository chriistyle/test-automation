package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var dynamicLoadingPage = homePage.clickDynamicLoadingLink().clickExample1Link();
        dynamicLoadingPage.clickStart();
        assertEquals(dynamicLoadingPage.getText(),"Hello World!","Text incorrect");
    }

    @Test
    public void testWaitUntilTextVisible(){
        var dynamicLoadingPage = homePage.clickDynamicLoadingLink().clickExample2Link();
        dynamicLoadingPage.clickStart();
        assertEquals(dynamicLoadingPage.getText(),"Hello World!","Text incorrect");
    }
}
