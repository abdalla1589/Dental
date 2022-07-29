package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends Patient {
    private WebDriver driver;
    private String pageTitle= "Overview - DentaLore - Clinic";
    public OverviewPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public String getTitle() {
        waitForTitleToBeDisplayed(pageTitle);
        return driver.getTitle();}
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
    public String getAddress()
    {
        return driver.findElement(By.xpath("(//table)[2]//tr[1]//td[2]")).getText().trim();
    }
    public String getInsurance()
    {
       String  primaryInsurance =driver.findElement(By.xpath("((//table)[3]//td)[2]")).getText().trim();
       String  secondaryInsurance =driver.findElement(By.xpath("((//table)[3]//td)[4]")).getText().trim();
       return primaryInsurance+","+secondaryInsurance;
    }
}
