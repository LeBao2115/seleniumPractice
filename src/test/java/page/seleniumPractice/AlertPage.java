package page.seleniumPractice;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
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

    public void waitForAlert(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void clickBtnAlert(int num){
        String numStr = String.valueOf(num);
        clickDynamicElement(btnAlertLocateString,numStr);
    }

    public void acceptAlert() {
        webDriver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        webDriver.switchTo().alert().dismiss();
    }

    public void inputAlert(String text) {
        webDriver.switchTo().alert().sendKeys(text);
    }

    public String getTextAlert() {
        return webDriver.switchTo().alert().getText();
    }

    public String getTextResultComfirmAlert(){
        WebElement resultComfirmAlert = webDriver.findElement(resultConfirmAlert);
        return resultComfirmAlert.getText();
    }
}
