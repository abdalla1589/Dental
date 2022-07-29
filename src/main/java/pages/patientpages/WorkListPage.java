package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class WorkListPage {
    WebDriver driver;
    public WorkListPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
