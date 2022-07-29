package recall;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class RecallTests extends BaseTests {
    @Test
    public void testRecallTitle() {
        homePage.closePopupMenu();
        var recallPage = homePage.clickOnRecall();
        assertEquals(recallPage.getTitle(), "Recall List - DentaLore - Clinic", "recall title is not correct");

    }
}
