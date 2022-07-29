package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewPatientPage extends PatientInfoPage {
    private WebDriver driver;
    public NewPatientPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}