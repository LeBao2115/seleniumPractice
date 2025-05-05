package POM.base;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;
    private String tutorialspointUrl = "https://www.tutorialspoint.com/";
    private String downloadFilepath = "src/test/resources";


    @BeforeMethod
    public void setUp(){
        // configure Chrome for dowload
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(tutorialspointUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown(){
        // Close the browser after each test
        if (webDriver != null) {
//            webDriver.quit();
        }
    }

    public void takeScreenshot(String title){
        TakesScreenshot ts = (TakesScreenshot) webDriver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(title, new ByteArrayInputStream(screenshot));
    }

    public void switchTab(String title){
        webDriver.switchTo().window(title);
    }

    public void delay10s(){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
