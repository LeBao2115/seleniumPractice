package test.seleniumPractice;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SeleniumHomePage;
import page.seleniumPractice.AlertFrameWindow;
import page.seleniumPractice.Form;
import test.SeleniumHomeTest;

import java.util.ArrayList;
import java.util.List;

public class TestFrames extends BaseTest {
    private Form form;
    private SeleniumHomeTest seleniumHomeTest;
    private AlertFrameWindow alertFrameWindow;

    @BeforeMethod
    public void setUpPages() {
        form = new Form(webDriver);
        seleniumHomeTest = new SeleniumHomeTest();
        seleniumHomeTest.setUpDriver(webDriver);
        seleniumHomeTest.setUpPages();
        alertFrameWindow =  new AlertFrameWindow(webDriver);
    }

    @Test
    public void checkFrames() {
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToAlertFrameWindow();
        takeScreenshot("MoveToAlertFrameWindow");
        // Find Element Before switch frame
        alertFrameWindow.SwitchToFrame(0);
        // Find Element Before switch frame
        alertFrameWindow.clickNewTabFrame0();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        switchTab(tabs.get(0));
        alertFrameWindow.clickNewTabFrame1();
    }
}