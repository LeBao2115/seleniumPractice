package test.seleniumPractice;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.seleniumPractice.AlertPage;
import page.seleniumPractice.Form;
import test.SeleniumHomeTest;



public class TestAlert extends BaseTest {
    private SeleniumHomeTest seleniumHomeTest;
    private Form form;
    private AlertPage alertPage;

    @BeforeMethod
    public void setUpTest(){
        form = new Form(webDriver);
        alertPage = new AlertPage(webDriver);
        seleniumHomeTest = new SeleniumHomeTest();
        seleniumHomeTest.setUpDriver(webDriver);
        seleniumHomeTest.setUpPages();
    }

    @Test
    public void TestAllAlert(){
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToAlertPage();

        // Alert 1
        alertPage.clickBtnAlert(1);
        alertPage.waitForAlert();
        String AlertText = alertPage.getTextAlert();
        Assert.assertEquals(AlertText,"Hello world!");
        alertPage.acceptAlert();

        // Alert after 5s
        alertPage.clickBtnAlert(2);
        alertPage.waitForAlert();
        String AlertText5s = alertPage.getTextAlert();
        Assert.assertEquals(AlertText5s,"Hello just appeared");
        alertPage.acceptAlert();


        // Confirm alert
        alertPage.clickBtnAlert(3);
        alertPage.waitForAlert();
        String ConfirmAlertText = alertPage.getTextAlert();
        Assert.assertEquals(ConfirmAlertText,"Press a button!");
        alertPage.dismissAlert();
        Assert.assertEquals(alertPage.getTextResultComfirmAlert(),"You pressed Cancel!");

        // Input alert
        alertPage.clickBtnAlert(4);
        alertPage.waitForAlert();
        String inputAlertText = alertPage.getTextAlert();
        Assert.assertEquals(inputAlertText,"What is your name?");
        alertPage.inputAlert("Bao");
        alertPage.acceptAlert();
    }
}
