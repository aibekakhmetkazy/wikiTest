package pages;

import configs.PageConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static WebDriver driver;

    protected static PageConfig config;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void initConfig() {
        config = ConfigFactory.create(PageConfig.class);
    }
}
