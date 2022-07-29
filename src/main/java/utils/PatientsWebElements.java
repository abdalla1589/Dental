package utils;

import org.openqa.selenium.By;

  public final class PatientsWebElements {
    public static By getID()
    {
      return By.id("Id2");
    }
    public static By getSSN()
    {
      return By.id("SSN");
    }
    public static By getFirstName()
    {
      return By.id("FirstName");
    }
    public static By getMiddleName()
    {
      return By.id("MiddleName");
    }
    public static By getLastName()
    {
      return By.id("LastName");
    }
    public static By getPatientTitle()
    {
      return  By.id("Title");
    }
    public static By getPreferredProvider()
    {
      return  By.name("PreferredProviderId_input");
    }
    public static By getSelfCheckBoxElement()
    {
      return  By.id("IsSelfHouseHead");
    }
    public static By getPrimaryInsurance()
    {
      return By.xpath("//a[@href=\"#collapse0\"]");
    }
    public static By getSaveButton()
    {
      return By.xpath("//button[@value=\"Save\"]");
    }
    public static By getSaveAndClose()
    {
      return By.xpath("//button[@value=\"SaveClose\"]");
    }

}
