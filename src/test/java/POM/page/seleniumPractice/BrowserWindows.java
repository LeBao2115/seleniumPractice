package POM.page.seleniumPractice;

import POM.base.BasePage;
import org.openqa.selenium.WebDriver;

public class BrowserWindows extends BasePage {
    private String newTab = "//h1[normalize-space()='Browser Windows']/following-sibling::button[text()='%s']";

    public BrowserWindows(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickNewTab(){
        clickDynamicElement(newTab,"New Tab");
    }

    public void clickNewWindow(){
        clickDynamicElement(newTab,"New Window");
    }

    public void clickNewWindowMessage(){
        clickDynamicElement(newTab,"New Window Message");
    }
}
