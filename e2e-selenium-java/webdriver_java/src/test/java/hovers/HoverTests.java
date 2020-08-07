package hovers;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.clickHoverPageLink();
        var caption = hoversPage.hoverOverFigures(1);
        assertTrue(caption.isCaptionDisplayed(),"Caption is not displayed");
        assertEquals(caption.getTitle(),"name: user1","Title is incorrect");
        assertEquals(caption.getLinkURL(),"https://the-internet.herokuapp.com/users/1","Link URL is incorrect");
        // on the link, what if the domain change, like the url is visited to another server like stg.
        assertTrue(caption.getLinkURL().endsWith("users/1"),"Link URL is incorrect");
    }
}
