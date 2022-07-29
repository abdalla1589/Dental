package pages.expenses;

import org.openqa.selenium.WebDriver;

public class ExpensesPage {
    WebDriver driver;
    public ExpensesPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
