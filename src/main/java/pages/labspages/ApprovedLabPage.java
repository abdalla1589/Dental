package pages.labspages;

import org.openqa.selenium.WebDriver;

public class ApprovedLabPage {
    WebDriver driver;
    public ApprovedLabPage(WebDriver driver) {
     this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
