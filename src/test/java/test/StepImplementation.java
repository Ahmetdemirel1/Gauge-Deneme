package test;

import base.BaseTest;
import base.GaugeBase;
import com.thoughtworks.gauge.*;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest {
    GaugeBase base;

    @BeforeScenario
    public void before(){
        PropertyConfigurator.configure("properties/log4j.properties");
        setUp();
        base = new GaugeBase(getDriver());
    }

    @AfterScenario
    public void afterMethod() {
        tearDown();
    }


    @Step("<url> adresine gidilir")
    public void navigateToLifebox( String url ) {
        base.navigateSite(url);

    }

}
