package page.seleniumPractice;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class UploadDownload extends BasePage {
    public By inputUpload = By.xpath("//input[@id='uploadFile']");
    public By lnkDownload = By.xpath("//a[@id='downloadButton']");

    public UploadDownload(WebDriver webDriver) {
        super(webDriver);
    }

    public void UploadFile(File file){
        WebElement fileInput = webDriver.findElement(inputUpload);
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void downloadFile(){
        WebElement lnkDownloadFile = webDriver.findElement(lnkDownload);
        lnkDownloadFile.click();
    }
}
