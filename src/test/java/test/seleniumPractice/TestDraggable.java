package test.seleniumPractice;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SeleniumHomePage;
import page.seleniumPractice.Draggable;
import page.seleniumPractice.Form;

public class TestDraggable extends BaseTest {
    private HomePage homePage;
    private SeleniumHomePage seleniumHomePage;
    private Form form;
    private Draggable draggable;


    @BeforeMethod
    public void setUpTest(){
        homePage = new HomePage(webDriver);
        seleniumHomePage = new SeleniumHomePage(webDriver);
        form = new Form(webDriver);
        draggable = new Draggable(webDriver);
    }

    @Test
    public void TC001(){
        homePage.navigateSeleniumPage();
        seleniumHomePage.navigatePracticeWeb();
        form.MoveToDraggablesPage();
        draggable.MoveDivTo(100,200);
    }
}
