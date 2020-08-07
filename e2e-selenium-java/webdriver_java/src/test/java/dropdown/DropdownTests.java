package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropdownPage = homePage.clickDropdownLink();

        //if variable is called more than one, it is best to store it into a variable
        String option = "Option 1";

        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOption();
        assertEquals(selectedOptions.size(),1,"Incorrect number of Selected Options");
        assertTrue(selectedOptions.contains(option),"Option not selected");
    }

    @Test
    public void multipleSelectedDropdownTest(){
        var dropdownPage = homePage.clickDropdownLink();
        var optionsToSelect = List.of("Option 1","Option 2");


        // String[] -> Array
        // list.of() -> Collections

        dropdownPage.addMultipleAttOnDropdown();
        dropdownPage.selectMultipleOptions(optionsToSelect);

        assertTrue(dropdownPage.getSelectedOption().containsAll(optionsToSelect),"Options incorrect");
    }

}
