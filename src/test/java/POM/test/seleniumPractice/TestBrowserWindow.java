package POM.test.seleniumPractice;

import POM.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POM.page.seleniumPractice.BrowserWindows;
import POM.page.seleniumPractice.Form;
import POM.test.SeleniumHomeTest;

import java.util.ArrayList;

public class TestBrowserWindow extends BaseTest {
    private BrowserWindows browserWindows;
    private SeleniumHomeTest seleniumHomeTest;
    private Form form;

    @BeforeMethod
    public void setUpTest(){
        seleniumHomeTest = new SeleniumHomeTest();
        seleniumHomeTest.setUpDriver(webDriver);
        seleniumHomeTest.setUpPages();
        browserWindows = new BrowserWindows(webDriver);
        form = new Form(webDriver);
    }

    @Test
    public void testNewTab(){
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToBrowserWindow();
        takeScreenshot("MoveToBrowserWindow");

        // New Tab
        browserWindows.clickNewTab();
        ArrayList<String> tabList = new ArrayList<String>(webDriver.getWindowHandles());
        switchTab(tabList.get(1));
        takeScreenshot("New Tab");
        switchTab(tabList.get(0));

        // New Window
        browserWindows.clickNewWindow();
        tabList = new ArrayList<String>(webDriver.getWindowHandles());
        switchTab(tabList.get(2));
        takeScreenshot("New Window");
        switchTab(tabList.get(0));

        // New Window Message
        browserWindows.clickNewWindowMessage();
        tabList = new ArrayList<String>(webDriver.getWindowHandles());
        switchTab(tabList.get(2));
        takeScreenshot("New Window Message");
    }
}
