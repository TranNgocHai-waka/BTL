package test;

import core.BaseTest;
import org.testng.annotations.DataProvider;
import utils.ExcelUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.Actions.AddCustomerActions;
import page.UI.AddCustomerUI;
import utils.ScreenShot;

import java.io.IOException;

@Listeners(utils.TestListener.class)
public class TC_AddCustomer extends BaseTest {
    public AddCustomerActions addCustomerActions;
    public String path = System.getProperty("user.dir");

    @BeforeClass
    public void callDriven() throws IOException {
        addCustomerActions = new AddCustomerActions(driver);
        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
    }

    @DataProvider(name="fail_add")
    public Object[][] getDataFailFromExcel() throws IOException {
        ExcelUtils.setExcelFile(path + "/src/test/resources/AddCus.xlsx", "Fail_AddCustomer");
        String file = path + "\\src\\test\\resources\\AddCus.xlsx";
        String sheet = "Fail_AddCustomer";
        Object[][] dataLogin = ExcelUtils.getTableArray(file,sheet);
        return dataLogin;
    }

    //sau khi bo di dong dau, no se tu nhan cot dau la email, 2 là pass
    @Test(dataProvider = "fail_add")
    public void fail_AddCustomer_01(String nameTestCase, String firstName, String lastName, String email, String address, String mobileNumber, String message, String xPath) throws InterruptedException {
        System.out.println(nameTestCase);
        addCustomerActions.sendKeys(firstName, lastName, email, address, mobileNumber);
        addCustomerActions.clickToSubmit();
        addCustomerActions.closeAlert();
        Thread.sleep(2000);
        addCustomerActions.assertMessage(message, xPath);
    }

    @DataProvider(name="success_add")
    public Object[][] getDataSuccessFromExcel() throws IOException {
        ExcelUtils.setExcelFile(path + "/src/test/resources/AddCus.xlsx", "Success_AddCustomer");
        String file = path + "\\src\\test\\resources\\AddCus.xlsx";
        String sheet = "Success_AddCustomer";
        Object[][] dataLogin = ExcelUtils.getTableArray(file,sheet);
        return dataLogin;
    }

    @Test(dataProvider = "success_add")
    public void success_AddCustomer_01(String nameTestCase, String firstName, String lastName, String email, String address, String mobileNumber, String message, String xPath) throws InterruptedException {
        System.out.println(nameTestCase);
        addCustomerActions.sendKeys(firstName, lastName, email, address, mobileNumber);
        addCustomerActions.clickToSubmit();
        addCustomerActions.assertMessage(message, xPath);
    }
}
