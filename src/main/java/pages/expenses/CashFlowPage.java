package pages.expenses;

import org.openqa.selenium.WebDriver;

public class CashFlowPage {
    WebDriver driver;
    public CashFlowPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
