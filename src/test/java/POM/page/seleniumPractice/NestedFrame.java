package POM.page.seleniumPractice;

import POM.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NestedFrame extends BasePage {

    private By iframe1 = By.name("frame1");
    private By iframe2 = By.name("frame2");
    private By newTablnk = By.xpath("//a[@title='back to Selenium Tutorial']");


    public NestedFrame(WebDriver webDriver) {
        super(webDriver);
    }

    public void switchToFrame1(){
        WebElement frame1 = webDriver.findElement(iframe1);
        webDriver.switchTo().frame(frame1);
    }

    public void switchToFrame2(){
        WebElement frame2 = webDriver.findElement(iframe2);
        webDriver.switchTo().frame(frame2);
    }

    public void clickNewTab(){
        scrollToElement(newTablnk);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(newTablnk));
        clickElement(newTablnk);
    }
}
