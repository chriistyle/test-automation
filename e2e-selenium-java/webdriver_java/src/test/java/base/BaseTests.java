package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertFalse;

public class BaseTests {

    // Usual Webdriver
//    private WebDriver driver;

    // EventFiringWebdriver
    private EventFiringWebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        goHome();
        homePage = new HomePage(driver);

        /*
        All About Cookies
        setCookies -> Will make a new cookies
        deleteCookie -> will delete one cookie. just provide, name, value and domainName
        isCookieExisting -> will validate if the cookie is exisiting or not. Boolean

        setCookie("tau","123","the-internet.herokuapp.com");
        deleteCookie("optimizelyBuckets","%7B%7D",".the-internet.herokuapp.com");
        assertFalse(isCookieExisting("optimizelyBuckets"));

         */
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void quitSession() {
        driver.quit();

        /*
        COMMENTS:
         // will close the existing windows or session
         driver.quit();

         // will close the window but not the session
         driver.close();
         */
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,
                        new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // Deprecated
        // It will remove the info bar that displays
        // "Chrome is being controlled by automated test software"
        options.addArguments("disable-infobars");

        // IF headless is set to true, it will not launch the chromedriver
        // options.setHeadless(true);
        return options;
    }

    private void setCookie(String name, String value, String domainName) {
        Cookie cookie = new Cookie.Builder(name, value)
                .domain(domainName)
                .build();
        driver.manage().addCookie(cookie);
    }

    private void deleteCookie(String name, String value, String domainName) {
        Cookie cookie = new Cookie.Builder(name, value)
                .domain(domainName)
                .build();
        driver.manage().deleteCookie(cookie);
    }


    private boolean isCookieExisting(String cookieName) {
        var cookies = driver.manage().getCookies();

        for (var cookie: cookies)
            if(cookie.getName() == cookieName)
                return true;
        return false;
    }
}
