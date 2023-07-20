package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

    WebDriverWait wait;
    int TIME_UNIT = 30;

    //chua cac method dung chung cho toan bo project
    public void explicitWait(WebDriver driver, String locator) {
        wait = new WebDriverWait(driver, TIME_UNIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getElementByXpath(locator)));
        //wait.until(ExpectedConditions.elementToBeClickable(getElement(driver, locator)));
    }
    public By getElementByXpath(String locator) {
        return By.xpath(locator);//driver.findEle...();
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getElementByXpath(locator));
    }

    public void sendKeysToElement(WebDriver driver, String locator, String value) {
        explicitWait(driver, locator);
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    public void clickToElement(WebDriver driver, String locator) {
        explicitWait(driver, locator);
        getElement(driver, locator).click();
    }

    public String getTextOfElement(WebDriver driver, String locator) {
        explicitWait(driver, locator);
        return getElement(driver, locator).getText();
    }

    public boolean getDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean checkElementIsSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }
}
