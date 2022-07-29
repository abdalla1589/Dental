package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddProcedurePage extends ProcedureInfo {
    private WebDriver driver;

    public AddProcedurePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
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
    private String[] getPatientInfo(By element,String regex, int limit)
    {
        String Info = driver.findElement(By.id("HeaderPatientInfo")).getText();
        return Info.split(regex, limit);
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
