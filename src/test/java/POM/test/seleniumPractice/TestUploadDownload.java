package POM.test.seleniumPractice;

import POM.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POM.page.seleniumPractice.Form;
import POM.page.seleniumPractice.UploadDownload;
import POM.test.SeleniumHomeTest;

import java.io.File;

public class TestUploadDownload extends BaseTest {
    private Form form;
    private SeleniumHomeTest seleniumHomeTest;
    private UploadDownload uploadDownload;

    @BeforeMethod
    public void setUpPages() {
        form = new Form(webDriver);
        seleniumHomeTest = new SeleniumHomeTest();
        seleniumHomeTest.setUpDriver(webDriver);
        seleniumHomeTest.setUpPages();
        uploadDownload = new UploadDownload(webDriver);
    }

    @Test
    public void checkUpload() {
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToUploadDownloadPage();
        takeScreenshot("MoveToUploadDownloadPage");
        File uploadFile = new File("src/test/resources/sampleFile.jpeg");
        uploadDownload.UploadFile(uploadFile);
    }

    @Test
    public void checDownload() {
        seleniumHomeTest.testNavigatePracticeWeb();
        form.MoveToUploadDownloadPage();
        takeScreenshot("MoveToUploadDownloadPage");
        uploadDownload.downloadFile();
    }
}
