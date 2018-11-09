package util;

import base.BaseTest;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Browser {
    protected final Logger log = Logger.getLogger(Browser.class);
    private DesiredCapabilities capabilities;
    public static final String USERNAME = "ahmetdemirel";
    public static final String ACCESS_KEY = "bba815c75f0c90da38b258e1df762c06";
    public static final String KEY = USERNAME + ":" + ACCESS_KEY;
    public static final String URL = "http://hub.testinium.io/wd/hub";

    public void setBrowser( String browserName, String browserVersion, String url, int implicitlyWait)
            throws MalformedURLException {


            URL hub = new URL(URL);
            String key = "ahmetdemirel:bba815c75f0c90da38b258e1df762c06";
            if(StringUtils.isNotEmpty(key)){
                log.info("Testinium ");
                ChromeOptions options = new ChromeOptions();
                capabilities = DesiredCapabilities.chrome();
                options.addArguments("test-type");
                options.addArguments("disable-popup-blocking");
                options.addArguments("ignore-certificate-errors");
                options.addArguments("disable-translate");
                options.addArguments("start-maximized");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability("key",key);
                //BaseTest.setDriver(new RemoteWebDriver(hub, capabilities));


        }
        else if (StringUtils.isNotEmpty(key) && browserName != null ){
                log.info("Default");
                ChromeOptions options = new ChromeOptions();
                capabilities = DesiredCapabilities.chrome();
                options.addArguments("test-type");
                options.addArguments("disable-popup-blocking");
                options.addArguments("ignore-certificate-errors");
                options.addArguments("disable-translate");
                options.addArguments("start-maximized");
                capabilities.setCapability(ChromeOptions.CAPABILITY,options);
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.getCurrent());

                selectPath(capabilities.getPlatform());
                createLocalDriver();

                BaseTest.getDriver().manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
                BaseTest.getDriver().manage().window().maximize();
                log.info("Installation Complete");
                log.info("********* BROWSER:" + capabilities.getBrowserName() + ", " + "VERSION:" + capabilities.getVersion()
                        + ", " + "PLATFORM:" + capabilities.getPlatform());


            }

    }

    public void createLocalDriver(){
       /** // setSetUrl("URL");
         FirefoxProfile ffprofile = new FirefoxProfile();
         //ffprofile.setPreference("network.http.phishy-userpass-length", 255);
         //ffprofile.setPreference("network.automatic-ntlm-auth.trusted-uris", "http://10.10.27.36:2215"); // Set this to your DOMAIN, instead of
         ffprofile.setPreference(
         "network.automatic-ntlm-auth.allow-non-fqdn", "true");
         ffprofile.setPreference("network.ntlm.send-lm-response", "true");
         capabilities = DesiredCapabilities.firefox();
         capabilities.setBrowserName("firefox");
         capabilities.setPlatform(Platform.getCurrent());
         selectPath(capabilities.getPlatform());
         BaseTest.setDriver(new FirefoxDriver(capabilities));
         BaseTest.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);




         **/

        ChromeOptions options = new ChromeOptions();
        capabilities = DesiredCapabilities.chrome();
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-translate");
        //				options.addArguments("--kiosk");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.getCurrent());
        selectPath(capabilities.getPlatform());

        BaseTest.setDriver(new ChromeDriver(capabilities));
        BaseTest.getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);




    }
    public WebDriver getDriver() {
        return BaseTest.getDriver();
    }

    protected void selectPath( Platform platform ) {
        String browser;
        if ("CHROME".equalsIgnoreCase(capabilities.getBrowserName())) {
            browser = "webdriver.chrome.driver";
            switch (platform) {
                case MAC:
                    System.setProperty(browser, "properties/driver/chromedrivermac");
                    break;
                case WIN10:
                case WIN8:
                case WIN8_1:
                case WINDOWS:
                    System.setProperty(browser, "properties/driver/chromedriverwin.exe");
                    break;
                case LINUX:
                    System.setProperty(browser, "properties/driver/chromedriverlinux64.exe");
                    break;
                default:
                    log.info("PLATFORM DOES NOT EXISTS");
                    break;
            }
        }else if("FIREFOX".equalsIgnoreCase(capabilities.getBrowserName())){
            browser = "webdriver.gecko.driver";
            switch (platform) {
                case MAC:
                    System.setProperty(browser, "properties/driver/geckodrivermac");
                    break;
                case WIN10:
                case WIN8:
                case WIN8_1:
                case WINDOWS:
                    System.setProperty(browser, "properties/driver/geckodriverwin.exe");
                    break;
                case LINUX:
                    System.setProperty(browser, "properties/driver/geckodriverlinux64.exe");
                    break;
                default:
                    log.info("PLATFORM DOES NOT EXISTS");
                    break;
            }
        }
    }
}
