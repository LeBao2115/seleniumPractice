package test;

import base.BaseTest;
import org.testng.annotations.Test;
import page.HomePage;
import page.SeleniumHomePage;

public class SeleniumHomeTest extends BaseTest {
    @Test
    public void testNavigatePracticeWeb(){
        HomePage homePage = new HomePage(webDriver);
        homePage.navigateSeleniumPage();
        takeScreenshot("Move to Selenium Home");

        SeleniumHomePage seleniumHomePage = new SeleniumHomePage(webDriver);
        seleniumHomePage.navigatePracticeWeb();
        takeScreenshot("Move to Practice Web");
    }
}
