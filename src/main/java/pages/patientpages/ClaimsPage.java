package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class ClaimsPage extends Patient {
    private WebDriver driver;
    public ClaimsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public String getTitle() {
        return driver.getTitle();}
}
