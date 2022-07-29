package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class ChartPage {
    private WebDriver driver;
    public ChartPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();}
}
