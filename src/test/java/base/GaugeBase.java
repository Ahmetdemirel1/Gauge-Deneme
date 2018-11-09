package base;

import org.openqa.selenium.WebDriver;

public class GaugeBase extends BasePage {
    public GaugeBase(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to Page
     *
     * @param url
     */
    public void navigateSite(String url) {
        navigateTo(url);
    }
}
