package pages.labspages;

import org.openqa.selenium.WebDriver;

public class DeliverdLabPage {
    WebDriver driver;
    public DeliverdLabPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
