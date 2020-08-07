package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testBackspace(){
        var keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPressesPage.getResultText(),"You entered: BACK_SPACE","Key pressed is incorrect");
    }

    @Test
    public void testTab(){
        var keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterText("A" + Keys.TAB);
        assertEquals(keyPressesPage.getResultText(),"You entered: TAB","Key pressed is incorrect");
    }
}
