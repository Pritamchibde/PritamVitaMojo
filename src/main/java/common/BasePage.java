package common;

import io.cucumber.java.*;
import jdk.jfr.Timespan;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver Driver) {
        this.driver = Driver;
    }
    @Before("@V_UI")
    public static void initializeFrameworkObjects() {
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After("@V_UI")
    public static void tearDown(Scenario scenario) {
//        if(scenario.isFailed()) {
//            scenario.embed(((TakesScreenshot)driver).getScreenshotsAs(OutputType.BYTES),"image/png");
////        }
//        else {
//            scenario.write("Scenario failed");
//        }
        driver.quit();
    }
}
