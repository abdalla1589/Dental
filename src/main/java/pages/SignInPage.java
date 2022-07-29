package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private By username = By.id("UserName");
    private By password =By.id("Password");
    private By loginButton=By.id("login-btn");
    public SignInPage(WebDriver driver)
    {
        this.driver =driver;
    }
    public void setUsername(String user)
    {
        driver.findElement(username).sendKeys(user);
    }
    public void setPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }
    public HomePage clickLogin()
    {
        driver.findElement(loginButton).click();
        return new HomePage(driver);

    }
}
