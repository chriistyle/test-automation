package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class NavigationTests extends BaseTests {


    @Test
    public void testNavigation(){
        homePage.clickDynamicLoadingLink().clickExample1Link();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com/");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindowLink().clickHere();
        getWindowManager().switchTabByWindowTitle("New Window");
    }

    @Test
    public void testSwitchTab_2(){
        var dynamicLoadingPage = homePage.clickDynamicLoadingLink();
        var dynamicLoading_example2Page = dynamicLoadingPage.openExample2InNewTab();
        getWindowManager().switchToLastTab();
        assertTrue(dynamicLoading_example2Page.isStartButtonDisplayed());
    }
}
