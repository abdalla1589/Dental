package pages.patientpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProcedureInfo extends Patient {
    WebDriver driver;

    public ProcedureInfo(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setProcedureName() throws InterruptedException {
        driver.findElement(By.xpath("//span[@aria-controls=\"ProcedureCodeId_listbox\"]")).click();
      //Thread.sleep(5000);
      waitForElementToBeDisplayed(By.xpath("//ul[@id='ProcedureCodeId_listbox']/li[contains(text(),'D40 - Abfraction')]"));
     driver.findElement(By.xpath("//ul[@id='ProcedureCodeId_listbox']/li[contains(text(),'D40 - Abfraction')]")).click();

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
