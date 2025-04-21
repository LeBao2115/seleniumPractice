package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void clickElement(By locator){
        webDriver.findElement(locator).click();
    }

    protected void scrollToElement(By locator){
        WebElement scrollElement = webDriver.findElement(locator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
    }

    protected void inputText(By locator,String text){
        webDriver.findElement(locator).sendKeys(text);
    }
}
