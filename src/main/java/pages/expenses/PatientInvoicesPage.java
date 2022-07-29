package pages.expenses;

import org.openqa.selenium.WebDriver;

public class PatientInvoicesPage {
    WebDriver driver;
    public PatientInvoicesPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
