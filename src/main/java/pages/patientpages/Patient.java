package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Wait;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Wait {
    private WebDriver driver;

    public Patient(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    private By patientsSize= By.id("PatientMenu");
    public OverviewPage clickOnOverviewPage()
    {
        driver.findElement(By.id("Overview")).click();
        return new OverviewPage(driver);
    }
    public EditPatientPage clickOnInfoPage()
    {
        click(By.id("InfoMenu2"));
        return new EditPatientPage(driver);
    }
    public APPTPage clickOnAPPTPage()
    {
       return null;
    }
    public EMRPage clickOnEMRPage()
    {
        click(By.id("EmrMenu2"));
        return new EMRPage(driver);
    }
    public ChartPage clickOnChartPage()
    {
        click(By.id("Overview"));
        return new ChartPage(driver);
    }
    public ProcedurePage clickOnProcedurePage()
    {
        click(By.id("ProcedureMenu2"));
        return new ProcedurePage(driver);
    }
    public PrescriptionPage clickOnPrescriptionPage()
    {
        click(By.id("Overview"));
        return new PrescriptionPage(driver);
    }
    public ImagesPage clickOnImagesPage()
    {
        click(By.id("Overview"));
        return new ImagesPage(driver);
    }
    public DocsPage clickOnDocsPage()
    {
        click(By.id("Overview"));
        return new DocsPage(driver);
    }
    public LedgerPage clickOnLedgerPage()
    {
        click(By.id("Overview"));
        return new LedgerPage(driver);
    }
    public InvoicesPage clickOnInvoicesPage()
    {
        click(By.id("Overview"));
        return new InvoicesPage(driver);
    }
    public ClaimsPage clickOnClaimsPage()
    {
        click(By.id("Overview"));
        return new ClaimsPage(driver);
    }
    private void click(By element)
    {
        driver.findElement(element).click();
    }
    //return number of pages of a patient like overview , info ledger
    public List<String> getPatientPagesNames()
    {


        return getListFromWebElements(patientsSize);
    }
    public int getPatientPagesSize()
    {
        return getListFromWebElements(patientsSize).size();
    }
    private List<String> getListFromWebElements(By element)
    {
        List<WebElement> list =driver.findElements(element);
        List<String> patientPages = new ArrayList<>();
        for(int i =0;i<list.size();i++)
        {
            patientPages.add(list.get(i).getText());
        }
        return patientPages;
    }

}
