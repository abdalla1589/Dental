package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    private WebDriver driver;
    public Wait(WebDriver driver)
    {
        this.driver=driver;
    }

    public void waitForElementToBeDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void waitForElementToBeClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
    }
    public void waitForElementToBeStanless(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));
    }
    public void waitForTitleToBeDisplayed(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(ExpectedConditions.titleContains(title));
    }
}
