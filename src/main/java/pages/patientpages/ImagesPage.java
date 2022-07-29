package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class ImagesPage {
    private WebDriver driver;
    public ImagesPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();}
}
