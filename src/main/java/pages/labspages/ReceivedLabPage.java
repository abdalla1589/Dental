package pages.labspages;

import org.openqa.selenium.WebDriver;

public class ReceivedLabPage {
    WebDriver driver;
    public ReceivedLabPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
