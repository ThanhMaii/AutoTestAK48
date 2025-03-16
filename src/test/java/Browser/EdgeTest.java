package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class EdgeTest {
    @Test
    void openWithDefaultMode() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
    }
}
