package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProcedurePage {
    private WebDriver driver;
    private By addButton = By.cssSelector(".k-header .btn");

    public ProcedurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getID() {
        String[] patientInfo = getPatientInfo(By.id("HeaderPatientInfo"), " / ", 2);
        return patientInfo[0];
    }

    public String getName() {
        String[] patientInfo = getPatientInfo(By.id("HeaderPatientInfo"), " / ", 2);
        return patientInfo[1];
    }

    private String[] getPatientInfo(By element, String regex, int limit) {
        String Info = driver.findElement(By.id("HeaderPatientInfo")).getText();
        return Info.split(regex, limit);
    }

    public AddProcedurePage clickAddButton() {
        driver.findElement(addButton).click();
        return new AddProcedurePage(driver);
    }

}
