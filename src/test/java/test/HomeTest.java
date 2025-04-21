package test;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import page.HomePage;

public class HomeTest extends BaseTest {
    @Test
    public void testNavigateSeleniumHome(){
        HomePage homePage = new HomePage(webDriver);
        homePage.navigateSeleniumPage();
        takeScreenshot("Move to Selenium Home");
    }
}
