package page.seleniumPractice;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalDialogs extends BasePage {
    private String btnModalLocatorString = "//div[@class='col-md-8 col-lg-8 col-xl-8']/button[text()='%s']";
    private By btnCloseSmallModal = By.xpath("//div[@class='modal-dialog modal-sm']//button[text()]");
    private By btnCloseLargeModal = By.xpath("//div[@class='modal-dialog modal-lg']//button[text()]");

    public ModalDialogs(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickSmallModalBtn(){
        clickDynamicElement(btnModalLocatorString,"Small Modal");
    }

    public void clickLargeModalBtn(){
        clickDynamicElement(btnModalLocatorString,"Large Modal");
    }

    public void closeLargeModal(){
        clickElement(btnCloseLargeModal);
    }

    public void closeSmallModal(){
        clickElement(btnCloseSmallModal);
    }

    public void waitSmallDialogPresent(){
        WebElement revealed = webDriver.findElement(btnCloseSmallModal);
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        wait.until(d -> revealed.isDisplayed());
    }

    public void waitLargeDialogPresent(){
        WebElement revealed = webDriver.findElement(btnCloseLargeModal);
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        wait.until(d -> revealed.isDisplayed());
    }
}
