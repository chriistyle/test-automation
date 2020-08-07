package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        this.navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

    public void switchTabByWindowTitle(String windowTitle){
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs is "+windows);
        System.out.println("Window Handle");

        //It will printout every output of getWindowHandles
        windows.forEach(System.out::println);

        for(String window: windows){
            System.out.println("Switching to window:");
            driver.switchTo().window(window);
            System.out.println("You are now in "+driver.getTitle());

            if(windowTitle.equals(driver.getTitle()))
                break;
        }
    }

    /**
     * Hard code version of it. It will switch focus to the last tab of the browser
     *
     */
    public void switchToLastTab(){
        var windows = driver.getWindowHandles();
        int windowsCount = windows.size();

        System.out.println("Number of Tabs is "+windowsCount);

        System.out.println("Window Handles: ");
        windows.forEach(System.out::println);

        for(String window: windows){
            System.out.println("Switching to "+window);
            driver.switchTo().window(window);
        }
    }
}
