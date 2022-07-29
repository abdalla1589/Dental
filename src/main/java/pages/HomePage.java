package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HRpages.MyAttendancePage;
import pages.HRpages.TimeAttendancePage;
import pages.expenses.CashFlowPage;
import pages.expenses.ExpensesPage;
import pages.expenses.LabExpensesPage;
import pages.expenses.PatientInvoicesPage;
import pages.labspages.*;
import pages.messagingpages.DashboardPage;
import pages.messagingpages.LogPage;
import pages.patientpages.NewPatientPage;
import pages.patientpages.PatientsListPage;
import pages.patientpages.WorkListPage;
import pages.recallpages.RecallPage;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By homeButton = By.id("main-menu-toggle");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public String closePopupMenu() {
        clickByXpath("//*[@id=\"news-modal\"]/div/div/div[4]/button");
        return "popup is closed";

    }

    public void clickOnMenu() {
        driver.findElement(homeButton).click();
    }

    public RecallPage clickOnRecall() {
        clickById("RecallMenu1");
        return new RecallPage(driver);
    }

    public void clickOnPatientMenu() {
        clickById("PatientMenu1");
    }

    public Object selectPatientOption(String option) {
        if (option.toLowerCase().contains("patientlist")) {
            waitForElementToBeClickable("//a[@href=\"/dentaloredemo/Patient/Search/Index\"]");
            clickByXpath("//a[@href=\"/dentaloredemo/Patient/Search/Index\"]");
            return new PatientsListPage(driver);
        } else if (option.toLowerCase().contains("newpatient")) {
            waitForElementToBeClickable("//a[@href=\"/dentaloredemo/Patient/Info/Create\"]");
            clickByXpath("//a[@href=\"/dentaloredemo/Patient/Info/Create\"]");
            return new NewPatientPage(driver);
        } else {
            waitForElementToBeClickable("//a[@href=\"/dentaloredemo/Patient/WorkList/Index\"]");
            clickByXpath("//a[@href=\"/dentaloredemo/Patient/WorkList/Index\"]");
            return new WorkListPage(driver);
        }
    }

    public void clickOnFinancials() {
        clickById("FinancialMenu1");
    }

    public Object selectFinancialsOption(String option) {
        if (option.toLowerCase().contains("cashflow")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Financial/CashFlow/Index']");
            clickByXpath("//a[@href='/dentaloredemo/Financial/CashFlow/Index']");
            return new CashFlowPage(driver);
        } else if (option.toLowerCase().startsWith("expenses")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Financial/Expense/Index']");
            clickByXpath("//a[@href='/dentaloredemo/Financial/Expense/Index']");
            return new ExpensesPage(driver);
        } else if (option.toLowerCase().startsWith("lab")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Financial/LabExpense/Index']");
            clickByXpath("//a[@href='/dentaloredemo/Financial/LabExpense/Index']");
            return new LabExpensesPage(driver);
        } else {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Financial/PatientsInvoices/Index']");
            clickByXpath("//a[@href='/dentaloredemo/Financial/PatientsInvoices/Index']");
            return new PatientInvoicesPage(driver);
        }
    }

    public void clickOnHR() {
        clickById("HRMenu1");
    }

    public Object selectHROption(String option) {
        if (option.toLowerCase().startsWith("my")) {
            waitForElementToBeClickable("/dentaloredemo/HR/Attendance/MyAttendance");
            clickByXpath("//a[@href='/dentaloredemo/HR/Attendance/MyAttendance']");
            return new MyAttendancePage(driver);
        } else {
            waitForElementToBeClickable("/dentaloredemo/HR/Attendance/TimeAttendance");
            clickByXpath("//a[@href='/dentaloredemo/HR/Attendance/TimeAttendance");
            return new TimeAttendancePage(driver);
        }
    }

    public void clickOnLab() {
        clickById("LabMenu1");
    }

    public Object selectLabOption(String option) {
        if (option.toLowerCase().startsWith("new")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Lab/LabCase/Index/New']");
            clickByXpath("//a[@href='/dentaloredemo/Lab/LabCase/Index/New']");
            return new NewLabPage(driver);
        } else if (option.toLowerCase().startsWith("approved")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Lab/LabCase/Index/Approved']");
            clickByXpath("//a[@href='/dentaloredemo/Lab/LabCase/Index/Approved']");
            return new ApprovedLabPage(driver);
        } else if (option.toLowerCase().startsWith("ordered")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Lab/LabCase/Index/Ordered']");
            clickByXpath("//a[@href='/dentaloredemo/Lab/LabCase/Index/Ordered']");
            return new OrderedLabPage(driver);
        } else if (option.toLowerCase().startsWith("received")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Lab/LabCase/Index/Received']");
            clickByXpath("//a[@href='/dentaloredemo/Lab/LabCase/Index/Received']");
            return new ReceivedLabPage(driver);
        } else {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Lab/LabCase/Index/Delivered']");
            clickByXpath("//a[@href='/dentaloredemo/Lab/LabCase/Index/Delivered']");
            return new DeliverdLabPage(driver);
        }
    }

    public void clickOnMessaging() {
        clickById("MessagingMenu1");
    }

    public Object selectMessagingOption(String option) {
        if (option.toLowerCase().contains("Dashboard")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Messaging/Dashboard']");
            clickByXpath("//a[@href='/dentaloredemo/Messaging/Dashboard']");
            return new DashboardPage(driver);
        } else if (option.toLowerCase().contains("log")) {
            waitForElementToBeClickable("//a[@href='/dentaloredemo/Messaging/SMSLog']");
            clickByXpath("//a[@href='/dentaloredemo/Messaging/SMSLog']");
            return new LogPage(driver);
        } else return new HomePage(driver);
    }

    private void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    private void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    private void waitForElementToBeClickable(String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(element))));
    }
}
