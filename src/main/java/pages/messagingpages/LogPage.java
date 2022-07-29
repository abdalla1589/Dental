package pages.messagingpages;

import org.openqa.selenium.WebDriver;

public class LogPage {
    WebDriver driver;
    public LogPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
