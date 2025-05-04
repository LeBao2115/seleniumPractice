package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver webDriver; // protected

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void clickElement(By locator){
        webDriver.findElement(locator).click();
    }

    protected void clickDynamicElement(String locator, String name){
        String dropdownXpath = String.format(locator,name);
        By dropdown = By.xpath(dropdownXpath);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        webDriver.findElement(dropdown).click();
    }

    protected void scrollToElement(By locator){
        WebElement scrollElement = webDriver.findElement(locator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
    }

    protected void inputText(By locator,String text){
        webDriver.findElement(locator).sendKeys(text);
    }

    protected By dynamicLocator(String locator, String name){
        String locationXpath = String.format(locator,name);
        return By.xpath(locationXpath);
    }

    protected void DragElement(WebElement element,int xCoordinate, int yCoordinate){
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(element)
                .moveByOffset(xCoordinate, yCoordinate)
                .release()
                .build()
                .perform();
    }
}
