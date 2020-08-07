package menu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MenuTests extends BaseTests {

    @Test
    public void contextMenuTest(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.clickHotSpot();
        assertEquals(contextMenuPage.getAlertText(),"You selected a context menu","ALERT text incorrect");
        contextMenuPage.acceptAlertButton();
    }
}
