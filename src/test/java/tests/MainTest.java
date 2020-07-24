package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AviaResultPage;

public class MainTest extends BaseTest {

    @Test
    public void mainTest() {
        Assert.assertTrue(aviaSearchPage.aviaSearchPageIsLoaded(),"Avia search page is not loaded.");
        aviaSearchPage.inputData();
        aviaSearchPage.clickOnFindTicketsButton();
        AviaResultPage aviaResultPage = aviaSearchPage.changeTab();
        aviaResultPage.waitTickets();
        aviaResultPage.aviaResultPageIsLoaded();
        Assert.assertEquals(aviaResultPage.sumTickets(),10,"The number of tickets is wrong.");
    }
}
