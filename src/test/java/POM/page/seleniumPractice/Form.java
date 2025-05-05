package POM.page.seleniumPractice;

import POM.base.BasePage;
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

    public void MoveToBrowserWindow(){
        clickDynamicElement(stringDropdownXpath,"Alerts, Frames & Windows");
        clickDynamicElement(stringSubDropdownXpath,"Browser Windows");
    }

    public void MoveToAlertPage(){
        clickDynamicElement(stringDropdownXpath,"Alerts, Frames & Windows");
        clickDynamicElement(stringSubDropdownXpath,"Alerts");
    }

    public void MoveToNestedFramePage(){
        clickDynamicElement(stringDropdownXpath,"Alerts, Frames & Windows");
        clickDynamicElement(stringSubDropdownXpath,"Nested Frames");
    }

    public void MoveToModalDialogsPage(){
        clickDynamicElement(stringDropdownXpath,"Alerts, Frames & Windows");
        clickDynamicElement(stringSubDropdownXpath,"Modal Dialogs");
    }

    public void MoveToUploadDownloadPage(){
        clickDynamicElement(stringDropdownXpath,"Elements");
        clickDynamicElement(stringSubDropdownXpath,"Upload and Download");
    }
}
