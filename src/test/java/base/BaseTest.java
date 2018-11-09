package base;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.Browser;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.security.auth.login.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest  {


    public static RemoteWebDriver driver;
    private String methodName = null;
    protected static final Logger log = Logger.getLogger(BaseTest.class);
    //protected static Configuration config = Configuration.getInstance();
    protected static Browser browser = new Browser();

    public static void setUp() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        PropertyConfigurator.configure("properties/log4j.properties");
        log.info("Settings Installation Start");

        String key = null;
        if (StringUtils.isNotEmpty(key)) { //TESTINIUM'DA CALISMASI ICIN
            capabilities.setCapability("key", key);
            try {
                capabilities.setCapability("takesScreenshot", true);
                capabilities.setPlatform(Platform.MAC);
                setDriver(new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities));
            } catch (MalformedURLException e) {
                log.error(e.getMessage());
            }
        } else { // LOCAL'DE CALISMASI ICIN
            browser.createLocalDriver();
        }
    }
    public static void setDriver(RemoteWebDriver driver) {
        BaseTest.driver = driver;
    }

    public static void tearDown(){
        getDriver().quit();
    }


    public static RemoteWebDriver getDriver() {
        return driver;
    }

}
