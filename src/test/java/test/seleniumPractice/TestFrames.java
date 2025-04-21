package test.seleniumPractice;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SeleniumHomePage;
import page.seleniumPractice.Form;
import test.SeleniumHomeTest;

public class TestFrames extends BaseTest {
    private Form form;
    private SeleniumHomeTest seleniumHomeTest;

    @BeforeMethod
    public void setUpPages() {
        form = new Form(webDriver);
        seleniumHomeTest = new SeleniumHomeTest();
        seleniumHomeTest.setUpDriver(webDriver);
        seleniumHomeTest.setUpPages();
    }

    @Test
    public void checkFrames() {
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToAlertFrameWindow();
        takeScreenshot("MoveToAlertFrameWindow");
    }
}