package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class DocsPage {
    private WebDriver driver;
    public DocsPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();}
}
