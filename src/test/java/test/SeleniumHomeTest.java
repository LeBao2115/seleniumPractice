package test;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SeleniumHomePage;

public class SeleniumHomeTest extends BaseTest {
    private HomePage homePage;
    private SeleniumHomePage seleniumHomePage;

    public void setUpDriver(WebDriver driver){
        this.webDriver = driver;
    }

    @BeforeMethod
    public void setUpPages() {
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
