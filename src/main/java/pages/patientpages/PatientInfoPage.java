package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientInfoPage extends Patient{
    WebDriver driver;
    private By cancelButton = By.id("CancelPatientView");
    public PatientInfoPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }

    public void setID(String ID) {
        driver.findElement(By.id("Id2")).sendKeys(ID);
    }

    public void setSSN(String SSN) {
        driver.findElement(By.id("SSN")).sendKeys(SSN);
    }

    public void setFirstName(String firstName) {
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
    }

    public void setMiddleName(String middleName) {
        driver.findElement(By.id("MiddleName")).sendKeys(middleName);
    }

    public void setLastName(String lastName) {
        driver.findElement(By.id("LastName")).sendKeys(lastName);
    }

    public void setTitle(String Title) {
        driver.findElement(By.id("Title")).sendKeys(Title);
    }

    public void setSelfCheckBox() {
        driver.findElement(By.id("IsSelfHouseHead")).click();
    }

    public void setPreferredProvider(String option) {
        driver.findElement(By.name("PreferredProviderId_input")).sendKeys(option);
    }

    public void setPrimaryInsurance() {
        driver.findElement(By.xpath("//a[@href=\"#collapse0\"]")).click();
        driver.findElement(By.id("add-InsurancePlanAutoComplete-0")).click();
        waitForElementToBeClickable(By.name("CompanyId_input"));
        driver.findElement(By.name("CompanyId_input")).sendKeys("main");
        driver.findElement(By.xpath("(//div/input[@id=\"Name\"])[2]")).sendKeys("name");
        driver.findElement(By.id("coverageTab")).click();
        waitForElementToBeClickable(By.xpath("(//input[@class=\"k-formatted-value k-input\"])[12]"));
        driver.findElement(By.xpath("(//input[@class=\"k-formatted-value k-input\"])[12]")).sendKeys("5000");
        driver.findElement(By.id("save-plan-btn")).click();
    }

    public EditPatientPage clickOnSaveButton() {
        driver.findElement(By.xpath("//button[@value=\"Save\"]")).click();
        return new EditPatientPage(driver);
    }

    public PatientsListPage clickOnSaveAndClose() {
        driver.findElement(By.xpath("//button[@value=\"SaveClose\"]")).click();
        return new PatientsListPage(driver);
    }

    public Object clickOnDeleteButton(String action)
    {
        waitForElementToBeDisplayed(By.id("DeletePatientBtn"));
        driver.findElement(By.id("DeletePatientBtn")).click();
        if (action.toLowerCase().contains("cancel"))
        {
            waitForElementToBeDisplayed(By.cssSelector("div.modal-footer #Cancelbtn"));
            driver.findElement(By.cssSelector("div.modal-footer #Cancelbtn")).click();
            return null;
        }
        else
        {
            waitForElementToBeDisplayed(By.id("deletePatient"));
            driver.findElement(By.id("deletePatient")).click();
            return new PatientsListPage(driver);
        }
    }
    public NewPatientPage clickOnCancelButton() {
        waitForElementToBeStanless(cancelButton);
        driver.findElement(cancelButton).click();
        return new NewPatientPage(driver);
    }
}
