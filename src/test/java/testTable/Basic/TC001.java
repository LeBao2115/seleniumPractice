package testTable.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC001 {
    private String url = "https://practice.expandtesting.com/dynamic-table";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void test001(){
//        WebElement firstName5 = driver.findElement(By.xpath("//tr[td[text()='Chrome']]/td[count(//tr[1]/th[text()='CPU']/preceding-sibling::th)+1]"));
//        String name = firstName5.getText();
//        System.out.println(name);

        List<WebElement> thTag = driver.findElements(By.xpath("//th"));
        int countCell = -1;
        for (int i = 0; i < thTag.size();i++){
            System.out.println(thTag.get(i).getText());
            if(thTag.get(i).getText().equals("CPU")){
                countCell = i;
            }
        }
        System.out.println(countCell);

        String xpath = "//tr[td[text()='Chrome']]//td";
        List<WebElement> results = driver.findElements(By.xpath(xpath));
        System.out.println(results.get(countCell).getText());
    }
}
