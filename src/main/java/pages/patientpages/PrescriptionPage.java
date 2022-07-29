package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class PrescriptionPage {
    private WebDriver driver;
    public PrescriptionPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();}
}
