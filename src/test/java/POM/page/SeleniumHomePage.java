package POM.page;

import POM.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumHomePage extends BasePage {

    private By AutomationPracticeLink = By.xpath("//a[normalize-space()='Selenium - Automation Practice']");
    private By Title = By.xpath("//h1[text()='Selenium Tutorial']");


    public SeleniumHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigatePracticeWeb(){
        scrollToElement(AutomationPracticeLink);
        clickElement(AutomationPracticeLink);
    }

}
