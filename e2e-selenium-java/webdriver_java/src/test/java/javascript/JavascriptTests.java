package javascript;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class JavascriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        var largeAndDeepDOMPage = homePage.clickLargeAndDeeoDOMLink();
        largeAndDeepDOMPage.scrollToTable();
    }

    @Test
    public void scrollIntoUserSpecifiedParagraphTest(){
        var infiniteScrollPage = homePage.clickInfiniteScrollLink();
        infiniteScrollPage.scrollToParagraph(5);
    }

//    @Test
//    public void addMultipleAttOnDropdownTest(){
//        var dropdownPage = homePage.clickDropdownLink();
//        dropdownPage.addMultipleAttOnDropdown();
//        List<String> options = ;
//        dropdownPage.getSelectedOption();
//        System.out.println("TEST");
//    }


}
