package base;


import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SignInPage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    protected SignInPage signInPage;
    protected HomePage homePage;
    private WebDriver driver;
    protected static Eyes eyes;

    @BeforeTest
    public void setup() {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goHome();
        signInPage = new SignInPage(driver);
       // initiateEyes();
    }

    @BeforeClass
    public void signIn() {
        signInPage.setUsername("administrator");
        signInPage.setPassword("Dent@loreAdmin1234567");
        HomePage homePage = signInPage.clickLogin();
        homePage.closePopupMenu();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://clinic.nebras-dentalore.com/dentaloredemo");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterTest
    public void tearDown() {
     //  driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    public void relativeLocator() {
        WebElement loginPanel = driver.findElement(By.id("logInPanelHeading"));
        WebElement credentials = driver.findElement(RelativeLocator.with(
                        By.tagName("span"))
                .above(loginPanel));
        // after RelativeLocator.with(put the element e1 you want to get).above below near to the left of to the right of(put the element which will use to look for the element e1)
    }
    private static void initiateEyes(){
        eyes = new Eyes();
        eyes.setApiKey("aCtYAOc2Ye55Iq0FeOk2QijealYtRvy6Iz1018kYj0DwQ110");
    }
   /* public void validateWindowContent(){
        eyes.open(driver, "Dentalore", Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.setMatchLevel(MatchLevel.CONTENT);
        eyes.checkWindow();
        eyes.close();
    }
    public void validateWindowLayout(){
        eyes.open(driver, "Dentalore", Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.checkWindow();
        eyes.close();
    }
    public void validateElement(By element)
    {
        eyes.open(driver, "Dentalore", Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.setMatchLevel(MatchLevel.CONTENT);
        eyes.checkElement(element);
        eyes.close();
    }

    */
}


