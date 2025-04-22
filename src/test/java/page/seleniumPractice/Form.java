package page.seleniumPractice;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class Form extends BasePage {
    private String stringDropdownXpath = "//button[@class='accordion-button collapsed' and normalize-space()='%s']";
    private String stringSubDropdownXpath = "//a[normalize-space()='%s']";

    public Form(WebDriver webDriver) {
        super(webDriver);
    }

    public void MoveToAlertFrameWindow(){
        clickDynamicElement(stringDropdownXpath,"Alerts, Frames & Windows");
        clickDynamicElement(stringSubDropdownXpath,"Frames");
    }
}
