package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class EdgeTest {
    @Test
    void openWithDefaultMode() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
    }

    @Test
    void openBrowserWithHeadlessMode() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        System.out.println("Page Title: " + driver.getTitle());
    }

    @Test
    void openBrowserWithMobileViewMode(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 344);
        deviceMetrics.put("height", 882);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
    }
}
