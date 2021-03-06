package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage{

    private WebDriver driver;

    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    /**
     *
     * @param index starts at 1
     *              figure 1 is 1
     */
    public FigureCaption hoverOverFigures(int index){

        WebElement figure = driver.findElements(figureBox).get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption{
        private WebElement caption;
        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        private By header = By.tagName("h5");
        private By link = By.linkText("View profile");

        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        public String getTitle(){
            return caption.findElement(header).getText();
        }

        public String getLinkURL(){
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}
