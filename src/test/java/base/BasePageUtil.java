package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageUtil {
    protected WebDriver driver;
    protected WebDriverWait wait;




    public BasePageUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);

    }


    /**
     *
     * @param by
     * @param index
     * @return
     */
    protected WebElement findElement(By by, int... index){
        if(index.length == 0){
            return (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

        }
        else if (index[0] >= 0){
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            if(!elements.isEmpty() && index[0] <= elements.size()) {
                return elements.get(index[0]);
            }
        }
        return null;
    }
    /**
     * Navigate to url
     *
     * @param url
     */
    protected void navigateTo(String url) {
        driver.navigate().to(url);
    }

}
