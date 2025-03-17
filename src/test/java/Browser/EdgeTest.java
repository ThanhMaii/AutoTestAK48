package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v133.emulation.Emulation;
import org.openqa.selenium.devtools.v133.network.Network;
import org.openqa.selenium.devtools.v133.network.model.ConnectionType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EdgeTest {
    // Open Edge Browser - Mở trình duyệt Edge
    @Test
    void openWithDefaultMode() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
    }

    // Open Edge Browser with Headless Mode - Mở không hiển thị giao diện
    @Test
    void openBrowserWithHeadlessMode() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        System.out.println("Page Title: " + driver.getTitle());
    }

    // Open Edge Browser with Mobile View Mode - Mở trình duyệt Edge với chế độ xem di động
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

    // Open Edge Browser with Specific Version - Mở trình duyệt Edge với phiên bản cụ thể
    @Test
    void openBrowserWithOldVersion(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setBrowserVersion("129");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    // Open Edge Browser with Beta Version - Mở trình duyệt Edge với phiên bản Beta
    @Test
    void openBrowerWithBetaVersion(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setBrowserVersion("130");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    // Open Edge Browser with Specific Profile - Mở trình duyệt Edge với Profile cụ thể
    @Test
    void openBrowserWithFakeGeoLocation(){
        WebDriver driver = new EdgeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        // Mountain view
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(37.386052),
                Optional.of(-122.083851),
                Optional.of(1)
        ));
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[.='Where am I?']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#lat-value")).getText(),"37.386052");
        Assert.assertEquals(driver.findElement(By.cssSelector("#long-value")).getText(),"-122.083851");
    }

    // Simulate Mobile Network Condition (3G/LTE) - Mô phỏng điều kiện mạng di động
    @Test
    void simulate3GNetworkCondition(){
        EdgeDriver driver = new EdgeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // Enable Network emulation
        devTools.send(Network.enable(Optional.of(100000000), Optional.empty(), Optional.empty()));

        // Set network conditions to emulate 3G or 4G
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                75000,
                25000,
                Optional.of(ConnectionType.ETHERNET),
                Optional.of(0),
                Optional.of(0),
                Optional.of(false)
        ));
        driver.get("https://selenium.dev");
    }
}
