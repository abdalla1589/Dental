package patients;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.patientpages.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PatientsTests extends BaseTests {
    private String id ="1907544588400";
    private String ssn ="1898499054562";
    private String firstName ="ahmed";
    private String middleName ="3l9aa";
    private String lastName ="ahmed";
    private String title ="Mr";
    @Test(priority = 1)
    public void testPatientlist() {
        homePage.clickOnPatientMenu();
        PatientsListPage patientList = (PatientsListPage) homePage.selectPatientOption("patientlist");
        patientList.setSearchBar("Abdallah Amr mohamed");
        patientList.clickOnSearchButton();
        patientList.clickOnName("Abdallah Amr mohamed");
       String name =patientList.getBirthDayOfSelectedPatient("Abdallah Amr mohamed");
        System.out.println("Actual"+name);
       EditPatientPage editPatientPage = patientList.clickOnInfoPage();
        System.out.println("Expected"+editPatientPage.getBirthDay());
        assertEquals(name,editPatientPage.getBirthDay(),"name is not the same");
    }

    @Test(priority = 2)
    public void testNewPatient()  {
        homePage.clickOnPatientMenu();
        NewPatientPage newPatient = (NewPatientPage) homePage.selectPatientOption("newpatient");
        assertEquals(newPatient.getTitle(), "Create Patient - DentaLore - Clinic", "patient list title is not correct");
        newPatient.setFirstName(firstName);
        newPatient.setMiddleName(middleName);
        newPatient.setLastName(lastName);
        newPatient.setTitle(title);
        newPatient.setSelfCheckBox();
        newPatient.setPrimaryInsurance();
       System.out.println(newPatient.getPatientPagesNames());
        System.out.println(newPatient.getPatientPagesSize());
     //PatientsListPage patientsListPage= (PatientsListPage) newPatient.clickOnDeleteButton("delete");
    //  String patientInfo=  editPatientPage.getPatientInfo();
    // editPatientPage.clickOnCancelButton();
     // assertEquals(searchTitle,"Patient Search - DentaLore - Clinic","Save and close is not clickable");
     // assertTrue(searchForPatientPage.getTitle().contains("Patient Search - DentaLore - Clinic"),"Save and close is not clickable");
     // assertEquals(patientInfo,id+" "+"/"+" "+firstName+" "+middleName+" "+lastName,"patient info is not correct");

    }

    @Test(priority = 3)
    public void testWorkList() {
        homePage.clickOnPatientMenu();
        WorkListPage workList = (WorkListPage) homePage.selectPatientOption("worklist");
        assertEquals(workList.getTitle(), "Work List - DentaLore - Clinic", "patient list title is not correct");
    }
    @Test(priority = 3)
    public void testClaims() {
        homePage.clickOnPatientMenu();
        WorkListPage workList = (WorkListPage) homePage.selectPatientOption("worklist");
        assertEquals(workList.getTitle(), "Work List - DentaLore - Clinic", "patient list title is not correct");
    }
    @Test(priority = 4)
    public void testEMR() throws InterruptedException {
        homePage.clickOnPatientMenu();
        PatientsListPage patientList = (PatientsListPage) homePage.selectPatientOption("patientlist");
        patientList.setSearchBar("Abdallah Amr mohamed");
        patientList.clickOnSearchButton();
        patientList.clickOnName("Abdallah Amr mohamed");
       ProcedurePage procedurePage= patientList.clickOnProcedurePage();
      AddProcedurePage addProcedurePage = procedurePage.clickAddButton();
        addProcedurePage.setProcedureName();

    }
}
