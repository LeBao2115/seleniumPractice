package POM.test.seleniumPractice;

import POM.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POM.page.seleniumPractice.Form;
import POM.page.seleniumPractice.ModalDialogs;
import POM.test.SeleniumHomeTest;

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
    public void TC001() throws InterruptedException {
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToModalDialogsPage();

        //Interact small modal
        modalDialogs.clickSmallModalBtn();
        modalDialogs.waitSmallDialogPresent();
        Thread.sleep(10000);
        takeScreenshot("SmallDialogPresent");
        modalDialogs.closeSmallModal();
        Thread.sleep(10000);
        takeScreenshot("closeSmallModal");

        //Interact large modal
        modalDialogs.clickLargeModalBtn();
        modalDialogs.waitLargeDialogPresent();
        Thread.sleep(10000);
        takeScreenshot("LargeDialogPresent");
        modalDialogs.closeLargeModal();
        Thread.sleep(10000);
        takeScreenshot("closeLargeModal");
    }
}
