package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class webdriver_actions {
    public static WebDriverWait wait;
    public WebDriver driver;

    //Constructor
    public webdriver_actions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    //Wait Wrapper Method
    public void waitVisibilityElement(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitVisibilityElements(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click(By elementBy) {
        waitVisibilityElement(elementBy);
        driver.findElement(elementBy).click();
    }

    //Click Method
    public void clear(By elementBy) {
        waitVisibilityElement(elementBy);
        driver.findElement(elementBy).clear();
    }

    //Write Text
    public void writeText(By elementBy, String text) {
        waitVisibilityElement(elementBy);
        click(elementBy);
        clear(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String getText(By elementBy) {
        waitVisibilityElement(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertEquals(By elementBy, String expectedText) {
        waitVisibilityElement(elementBy);
        Assert.assertEquals(getText(elementBy), expectedText);
    }

    public WebDriver implicitWait(int waitTimeinSeconds) {
        driver.manage().timeouts().implicitlyWait(waitTimeinSeconds, TimeUnit.SECONDS);
        return driver;
    }

    public WebElement element(By elementBy) {
        return driver.findElement(elementBy);
    }

    public WebDriver gotoUrl(String url) {
        driver.get(url);
        return driver;
    }
}
