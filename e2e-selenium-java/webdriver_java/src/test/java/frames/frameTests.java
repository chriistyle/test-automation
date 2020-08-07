package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class frameTests extends BaseTests {

    @Test
    public void wysiwygTests(){
        var wysiwigPage = homePage.clickWYSIWYGLink();
        wysiwigPage.clearTextArea();
        wysiwigPage.setTextArea("Hello ");
        wysiwigPage.increaseIndention();
        wysiwigPage.setTextArea("World");
        assertEquals(wysiwigPage.getText(),"Hello World","Text incorrect");
    }

    @Test
    public void nestedFramesTests(){
        var framesPage = homePage.clickFramesLink();
        var nestedFrames = framesPage.clickNestedFramesLink();
        assertEquals(nestedFrames.getLeftAreaText(),"LEFT","Left - wrong frame text");
        assertEquals(nestedFrames.getBottomAreaText(),"BOTTOM","Bottom - wrong frame text");
    }
}
