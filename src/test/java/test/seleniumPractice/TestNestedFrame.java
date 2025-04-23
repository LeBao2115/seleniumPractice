package test.seleniumPractice;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.seleniumPractice.Form;
import page.seleniumPractice.NestedFrame;
import test.SeleniumHomeTest;

public class TestNestedFrame extends BaseTest {
    private SeleniumHomeTest seleniumHomeTest;
    private Form form;
    private NestedFrame nestedFrame;

    @BeforeMethod
    public void setUpTest(){
        seleniumHomeTest = new SeleniumHomeTest();
        seleniumHomeTest.setUpDriver(webDriver);
        seleniumHomeTest.setUpPages();
        form = new Form(webDriver);
        nestedFrame = new NestedFrame(webDriver);
    }

    /*
    * In this case can not find //iframe[@id='frame2']
    * */
    @Test
    public void TC001(){
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToNestedFramePage();
        nestedFrame.switchToFrame1();
//        nestedFrame.clickNewTab();
//        nestedFrame.switchToFrame2();
        WebElement frame2 = webDriver.findElement(By.xpath("//iframe[@id='frame2']"));

// Get the srcdoc attribute
        String srcdoc = frame2.getAttribute("srcdoc");
        System.out.println(srcdoc);
    }
}
