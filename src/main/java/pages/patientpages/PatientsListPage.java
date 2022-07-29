package pages.patientpages;

import org.jsoup.select.Evaluator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PatientsListPage extends Patient {
    private WebDriver driver;
    private By headers = By.xpath("//table//th");
    private By rows = By.xpath("//table//tr");
    private By data = By.xpath("//table//td");
    private By searchBar = By.id("searchTextBox");
    private By searchbutton = By.id("searchicon");
    private By add = By.xpath("(//a[@href=\"/dentaloredemo/Patient/Info/Create\"])[2]");
    private String pageTitle = "Patient Search - DentaLore - Clinic";

    public PatientsListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTitle() {
        waitForTitleToBeDisplayed(pageTitle);
        return driver.getTitle();
    }

    public void setSearchBar(String searchName) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(searchName);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchbutton).click();
    }

    //get the names from fourth column
    public Boolean checkIfResultsExisting(String searchName) {
        Boolean status = false;
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                status = true;
            }
        }
        return status;
    }

    public void clickOnName(String searchName) {
        waitForElementToBeStanless(By.xpath("//table//td[4]"));
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                fourthColumnData.get(i).click();
                break;
            }
        }

    }

    public EditPatientPage clickOnViewIcon(String searchName) {
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                i++;
                driver.findElement(By.xpath("(//table//tr[" + i + "]//td[1]//i)[1]")).click();
                break;
            }
        }
        return new EditPatientPage(driver);
    }

    public void clickOnDeleteIcon(String searchName) {
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                i++;
                driver.findElement(By.xpath("(//table//tr[" + i + "]//td[1]//i)[2]")).click();

            }
        }

    }

    public void clickOnDeleteButton() {
        waitForElementToBeDisplayed(By.id("deletePatient"));
        driver.findElement(By.id("deletePatient")).click();
    }

    //get the headers of the search list as list of strings
    public List<String> getSearchListHeaders() {
        List<WebElement> headersList = driver.findElements(headers);
        List<String> searchListHeaders = new ArrayList<>();
        for (int i = 0; i < headersList.size(); i++) {
            searchListHeaders.add(headersList.get(i).getText());
        }
        return searchListHeaders;
    }

    public NewPatientPage clickOnAddButton() {
        driver.findElement(add).click();
        return new NewPatientPage(driver);
    }

    //get the size of the header of the search list
    public int getSearchListHeadersSize() {
        return getSearchListHeaders().size();
    }

    //check if element exist the list
    public boolean checkElement(List<String> list, String search) {
        search.toLowerCase();
        boolean status = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.contains(search)) ;
            status = true;
            break;
        }
        return status;
    }

    public String getIdOfTheSelectedPatient(String searchName) {
        String id = null;
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                i++;
                id = driver.findElement(By.xpath("//table//tr[" + i + "]//td[2]")).getText();
                break;
            }
        }
        return id;

    }
    public String getNameOfTheSelectedPatient(String searchName) {
        String name = null;
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                i++;
                name = driver.findElement(By.xpath("//table//tr[" + i + "]//td[4]")).getText().trim();
                break;
            }
        }
        return name;

    }
    public String getAddressOfTheSelectedPatient(String searchName) {
        String address = null;
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                i++;
                address = driver.findElement(By.xpath("//table//tr[" + i + "]//td[6]")).getText().trim();
                break;
            }
        }
        return address;
    }
    public String getInsuranceOfTheSelectedPatient(String searchName) {
        String address = null;
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                i++;
                address = driver.findElement(By.xpath("//table//tr[" + i + "]//td[8]")).getText().trim();
                break;
            }
        }
        return address;
    }
    public String getSSNOfSelectedPatient(String searchName)
    {
        String SSN = null;
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                i++;
                SSN = driver.findElement(By.xpath("//table//tr[" + i + "]//td[3]")).getText().trim();
                break;
            }
        }
        return SSN;
    }
    public String getBirthDayOfSelectedPatient(String searchName)
    {
        String birthDay = null;
        List<WebElement> fourthColumnData = driver.findElements(By.xpath("//table//td[4]"));
        for (int i = 0; i < fourthColumnData.size(); i++) {
            if (fourthColumnData.get(i).getText().toLowerCase().contains(searchName.toLowerCase())) {
                i++;
                birthDay = driver.findElement(By.xpath("//table//tr[" + i + "]//td[7]")).getText().trim();
                break;
            }
        }
        return birthDay;
    }
}