package POM.test.seleniumPractice;

import POM.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POM.page.seleniumPractice.Frames;
import POM.page.seleniumPractice.Form;
import POM.test.SeleniumHomeTest;

import java.util.ArrayList;

public class TestFrames extends BaseTest {
    private Form form;
    private SeleniumHomeTest seleniumHomeTest;
    private Frames alertFrameWindow;

    @BeforeMethod
    public void setUpPages() {
        form = new Form(webDriver);
        seleniumHomeTest = new SeleniumHomeTest();
        seleniumHomeTest.setUpDriver(webDriver);
        seleniumHomeTest.setUpPages();
        alertFrameWindow =  new Frames(webDriver);
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