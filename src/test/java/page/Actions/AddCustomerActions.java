package page.Actions;

import core.BasePage;
import org.testng.Assert;
import page.UI.AddCustomerUI;
import utils.ExcelUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AddCustomerActions extends BasePage {
    WebDriver driver;
    public AddCustomerActions(WebDriver driver){
        this.driver = driver;
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }
    public void sendKeys(String firstName, String lastName, String email, String address, String mobileNumber){
        sendKeysToElement(driver, AddCustomerUI.TXT_FIRSTNAME, firstName);
        sendKeysToElement(driver, AddCustomerUI.TXT_LASTNAME, lastName);
        sendKeysToElement(driver, AddCustomerUI.TXT_EMAIL, email);
        sendKeysToElement(driver, AddCustomerUI.TXT_ADDRESS, address);
        sendKeysToElement(driver, AddCustomerUI.TXT_MOBILE, mobileNumber);
    }

    public void clickToSubmit() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement btnSubmit = getElement(driver, AddCustomerUI.BTN_SUBMIT);
        executor.executeScript("arguments[0].click()", btnSubmit);
    }

    public void clickToReset() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement btnSubmit = getElement(driver, AddCustomerUI.BTN_RESET);
        executor.executeScript("arguments[0].click()", btnSubmit);
    }

    //Verify Actual result and Expected result after run test case
    public void assertMessage(String expectedMessage, String locator){
        String actualMessage = getTextOfElement(driver, locator);
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
