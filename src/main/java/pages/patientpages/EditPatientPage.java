package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class EditPatientPage extends PatientInfoPage {
    private WebDriver driver;


    public EditPatientPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private String[] getPatientInfo(By element,String regex, int limit)
    {
        String Info = driver.findElement(By.id("HeaderPatientInfo")).getText();
        return Info.split(regex, limit);
    }
    public String getID()
    {
        String[] patientInfo=getPatientInfo(By.id("HeaderPatientInfo")," / ",2);
        return patientInfo[0];
    }
    public String getName()
    {
        String[] patientInfo=getPatientInfo(By.id("HeaderPatientInfo")," / ",2);
        return patientInfo[1];
    }
    public String getSSN()
    {
        return driver.findElement(By.id("SSN")).getAttribute("value");
    }
    public String getAddress()
    {
        return driver.findElement(By.id("Address1")).getAttribute("value").trim();
    }
    public String getBirthDay()
    {
        return driver.findElement(By.id("BirthDate")).getAttribute("value").trim();
    }
}
