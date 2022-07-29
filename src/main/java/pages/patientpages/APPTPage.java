package pages.patientpages;

import org.openqa.selenium.WebDriver;

public class APPTPage {
  private WebDriver driver;
  public APPTPage(WebDriver driver) {
    this.driver=driver;
  }
  public String getTitle() {
    return driver.getTitle();}
}
