package POM.page;

import POM.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By categoryBtn = By.xpath("//button[span[normalize-space()='Category']]");
    private By categorySoftwareTesingBtn = By.xpath("//div[@class=' categories-menu']/div/ul/li[normalize-space()='Software Testing']");
    private By categorySoftwareTesingSeleniumBtn = By.xpath("//li[a[@title='Selenium']]");


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateSeleniumPage(){
        clickElement(categoryBtn);
        clickElement(categorySoftwareTesingBtn);
        clickElement(categorySoftwareTesingSeleniumBtn);
    }

}
