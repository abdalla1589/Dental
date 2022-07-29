package pages.expenses;

import org.openqa.selenium.WebDriver;

public class LabExpensesPage {
    WebDriver driver;
    public LabExpensesPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
