package POM.page.seleniumPractice;

import POM.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage extends BasePage {
    private String btnAlertLocateString = "(//label/following-sibling::button)[%s]";
    private String resultConfirmAlertLocator = btnAlertLocateString + "/following-sibling::div";
    private By resultConfirmAlert = dynamicLocator(resultConfirmAlertLocator,"3");

    public AlertPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("wait For Alert")
    public void waitForAlert(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("click Button Alert")
    public void clickBtnAlert(int num){
        String numStr = String.valueOf(num);
        clickDynamicElement(btnAlertLocateString,numStr);
    }

    @Step("Accept Alert")
    public void acceptAlert() {
        webDriver.switchTo().alert().accept();
    }

    @Step("Dismiss Alert")
    public void dismissAlert() {
        webDriver.switchTo().alert().dismiss();
    }

    @Step("input Alert")
    public void inputAlert(String text) {
        webDriver.switchTo().alert().sendKeys(text);
    }

    @Step("get text alert")
    public String getTextAlert() {
        return webDriver.switchTo().alert().getText();
    }

    public String getTextResultComfirmAlert(){
        WebElement resultComfirmAlert = webDriver.findElement(resultConfirmAlert);
        return resultComfirmAlert.getText();
    }
}
