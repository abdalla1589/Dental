package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class LedgerPage {
    private WebDriver driver;
    public LedgerPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();}
}
