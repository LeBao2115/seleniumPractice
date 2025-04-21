package test;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SeleniumHomePage;

public class SeleniumHomeTest extends BaseTest {
    private HomePage homePage;
    private SeleniumHomePage seleniumHomePage;

    @BeforeMethod
    public void setUpPages() {
        // Initialize page objects here, after webDriver is set up in BaseTest
        homePage = new HomePage(webDriver);
        seleniumHomePage = new SeleniumHomePage(webDriver);
    }

    @Test
    public void testNavigatePracticeWeb(){
        homePage.navigateSeleniumPage();
        takeScreenshot("Move to Selenium Home");
        seleniumHomePage.navigatePracticeWeb();
        takeScreenshot("Move to Practice Web");
    }
}
