package POM.test;

import POM.base.BaseTest;
import org.testng.annotations.Test;
import POM.page.HomePage;

public class HomeTest extends BaseTest {
    @Test
    public void testNavigateSeleniumHome(){
        HomePage homePage = new HomePage(webDriver);
        homePage.navigateSeleniumPage();
        takeScreenshot("Move to Selenium Home");
    }
}
