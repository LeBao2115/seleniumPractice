package POM.page.seleniumPractice;

import POM.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Frames extends BasePage {

    private By newTablnk = By.xpath("//a[@title='back to Selenium Tutorial']");
    private By iframe1 = By.xpath("//h2[text()='Iframe 2']/following-sibling::iframe");

    public Frames(WebDriver webDriver) {
        super(webDriver);
    }

    public void SwitchToFrame(int num){
        webDriver.switchTo().frame(num);
    }

    public void clickNewTabFrame0() {
        scrollToElement(newTablnk);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(newTablnk));
        clickElement(newTablnk);
    }

    public void clickNewTabFrame1() {
        WebElement iframe = webDriver.findElement(iframe1);
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(iframe);
        new Actions(webDriver)
                .scrollFromOrigin(scrollOrigin, 0, 100)
                .perform();
        webDriver.switchTo().frame(iframe);
        clickElement(newTablnk);
    }
}
