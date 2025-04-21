package base;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    private String tutorialspointUrl = "https://www.tutorialspoint.com/";

    @BeforeMethod
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(tutorialspointUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown(){
        // Close the browser after each test
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public void takeScreenshot(String title){
        TakesScreenshot ts = (TakesScreenshot) webDriver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(title, new ByteArrayInputStream(screenshot));
    }
}
