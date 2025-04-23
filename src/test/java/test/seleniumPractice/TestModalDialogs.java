package test.seleniumPractice;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.seleniumPractice.Form;
import page.seleniumPractice.ModalDialogs;
import page.seleniumPractice.NestedFrame;
import test.SeleniumHomeTest;

public class TestModalDialogs extends BaseTest {
    private SeleniumHomeTest seleniumHomeTest;
    private Form form;
    private ModalDialogs modalDialogs;

    @BeforeMethod
    public void setUpTest(){
        seleniumHomeTest = new SeleniumHomeTest();
        seleniumHomeTest.setUpDriver(webDriver);
        seleniumHomeTest.setUpPages();
        form = new Form(webDriver);
        modalDialogs = new ModalDialogs(webDriver);
    }

    /*
    * In this case can not find //iframe[@id='frame2']
    * */
    @Test
    public void TC001(){
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToModalDialogsPage();
        modalDialogs.clickSmallModalBtn();
        modalDialogs.waitSmallDialogPresent();
        modalDialogs.closeSmallModal();
        modalDialogs.clickLargeModalBtn();
        modalDialogs.waitLargeDialogPresent();
        modalDialogs.closeLargeModal();
    }
}
