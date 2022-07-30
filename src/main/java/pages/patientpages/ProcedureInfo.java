package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProcedureInfo extends Patient {
   private WebDriver driver;

    public ProcedureInfo(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setProcedureName(String procedureName) {
        driver.findElement(By.xpath("//span[@aria-controls=\"ProcedureCodeId_listbox\"]")).click();

        waitForElementToBeDisplayed(By.xpath("//ul[@id='ProcedureCodeId_listbox']/li[contains(text()," + procedureName + ")]"));
        driver.findElement(By.xpath("//ul[@id='ProcedureCodeId_listbox']/li[contains(text()," + procedureName + ")]")).click();

    }

    public String getProcedureName() {
        return driver.findElement(By.name("ProcedureCodeId_input")).getAttribute("value");
    }

    public void setProviderName(String providerName) {
        driver.findElement(By.xpath("//span[@aria-controls=\"ProviderId_listbox\"]")).click();
        waitForElementToBeDisplayed(By.xpath("//ul[@id='ProviderId_listbox']/li[contains(text()," + providerName + ")]"));
        driver.findElement(By.xpath("//ul[@id='ProviderId_listbox']/li[contains(text()," + providerName + ")]")).click();
    }
    public String getProviderName() {
        return driver.findElement(By.name("ProviderId_input")).getAttribute("value");
    }
    public boolean checkIfLabCostIsClickable()
    {
       return driver.findElement(By.id("LabCost")).isEnabled();
    }
    public boolean checkIfPriceListIsClickable()
    {
        return driver.findElement(By.id("Patient_PriceList_Name")).isEnabled();
    }
    public String getADACode()
    {
        return driver.findElement(By.id("ProcedureCode_AdaCode")).getText().trim();
    }
    public void setProcedureStatus(String procedureStatus)
    {
        driver.findElement(By.xpath("//span[@aria-owns=\"ProcedureStatus_listbox\"]")).click();
        waitForElementToBeDisplayed(By.xpath("//ul[@id='ProcedureStatus_listbox']/li[contains(text()," + procedureStatus + ")]"));
        driver.findElement(By.xpath("//ul[@id='ProcedureStatus_listbox']/li[contains(text()," + procedureStatus + ")]")).click();
    }
    public String getProcedureStatus()
    {
       return driver.findElement(By.xpath("//span[@aria-owns=\"ProcedureStatus_listbox\"]")).getText();
    }
    private List<String> getListFromWebElements(By element) {
        List<WebElement> list = driver.findElements(element);
        List<String> patientPages = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            patientPages.add(list.get(i).getAttribute("value"));
        }
        return patientPages;
    }

}
