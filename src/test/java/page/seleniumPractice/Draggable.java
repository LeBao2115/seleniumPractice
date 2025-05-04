package page.seleniumPractice;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Draggable extends BasePage {

    private By divDraggablesLocator = By.xpath("//div[@id='draggables']");

    public Draggable(WebDriver webDriver) {
        super(webDriver);
    }

    public void MoveDivTo(int x, int y){
        WebElement divDraggables = webDriver.findElement(divDraggablesLocator);
        DragElement(divDraggables,x,y);
    }
}
