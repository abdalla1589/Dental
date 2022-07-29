package pages.labspages;

import org.openqa.selenium.WebDriver;

public class NewLabPage {
    WebDriver driver;
    public NewLabPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
