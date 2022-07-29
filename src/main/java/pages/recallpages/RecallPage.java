package pages.recallpages;

import org.openqa.selenium.WebDriver;

public class RecallPage {
    private WebDriver driver;

    public RecallPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
