package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class InvoicesPage {
    private WebDriver driver;
    public InvoicesPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();}
}
