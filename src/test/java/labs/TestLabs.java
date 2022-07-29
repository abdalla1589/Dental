package labs;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.labspages.*;

import static org.testng.Assert.assertEquals;

public class TestLabs extends BaseTests {
    @Test(priority = 1)
    public void testNewLab() {
        homePage.clickOnLab();
        NewLabPage newLabPage = (NewLabPage) homePage.selectLabOption("new");
        assertEquals(newLabPage.getTitle(), "Lab - DentaLore - Clinic", "patient list title is not correct");
    }

    @Test(priority = 2)
    public void testApprovedLab() {
        homePage.clickOnLab();
        ApprovedLabPage approvedLabPage = (ApprovedLabPage) homePage.selectLabOption("approved");
        assertEquals(approvedLabPage.getTitle(), "Lab - DentaLore - Clinic", "patient list title is not correct");

    }

    @Test(priority = 3)
    public void testOrderedLab() {
        homePage.clickOnLab();
        OrderedLabPage orderedLabPage = (OrderedLabPage) homePage.selectLabOption("ordered");
        assertEquals(orderedLabPage.getTitle(), "Lab - DentaLore - Clinic", "patient list title is not correct");

    }

    @Test(priority = 4)
    public void testReceivedLab() {
        homePage.clickOnLab();
        ReceivedLabPage receivedLabPage = (ReceivedLabPage) homePage.selectLabOption("received");
        assertEquals(receivedLabPage.getTitle(), "Lab - DentaLore - Clinic", "patient list title is not correct");
    }

    @Test(priority = 5)
    public void testDeliverdLab() {
        homePage.clickOnLab();
        DeliverdLabPage deliverdLabPage = (DeliverdLabPage) homePage.selectLabOption("delivered");
        assertEquals(deliverdLabPage.getTitle(), "Lab - DentaLore - Clinic", "patient list title is not correct");
    }

}
