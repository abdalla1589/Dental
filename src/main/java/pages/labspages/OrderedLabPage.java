package pages.labspages;

import org.openqa.selenium.WebDriver;

public class OrderedLabPage {
    WebDriver driver;
    public OrderedLabPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
