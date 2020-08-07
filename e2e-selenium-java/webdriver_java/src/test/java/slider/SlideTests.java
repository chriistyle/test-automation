package slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SlideTests extends BaseTests {

    @Test
    public void moveSlideTest() {
        var horizontalSliderPage = homePage.clickHorizontalSliderLink();
        horizontalSliderPage.clickSlider();
        horizontalSliderPage.moveSlider(4);
        assertEquals(horizontalSliderPage.getSliderCount(),"4","Count is Incorrect");
    }
}
