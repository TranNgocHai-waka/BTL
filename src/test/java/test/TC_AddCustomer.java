package test;

import core.BaseTest;
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

    @BeforeClass
    public void callDriven() throws IOException {
        addCustomerActions = new AddCustomerActions(driver);
        String path = System.getProperty("user.dir");
        ExcelUtils.setExcelFile(path + "/src/test/resources/AddCus.xlsx", "AddCustomer");
        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
    }

//    @Test
//    public void swichToAddCustomerPage() {
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.TITLE_ADDCUSTOMER), "Add Customer");
//    }


    @DataProvider(name="fail_add")
    public Object[][] getDataFailFromExcel() throws IOException {
        String path = System.getProperty("user.dir");
        String file = path + "\\src\\test\\resources\\AddCus.xlsx";
        String sheet = "Fail_AddCustomer";
        Object[][] dataLogin = ExcelUtils.getTableArray(file,sheet);
        return dataLogin;
    }

    //sau khi bo di dong dau, no se tu nhan cot dau la email, 2 là pass
    @Test(dataProvider = "fail_add")
    public void fail_AddCustomer_01(String nameTestCase, String firstName, String lastName, String email, String address, String mobileNumber, String message) {
        System.out.println(nameTestCase);
        addCustomerAction
        WebElement txtEmail = driver.findElement(By.id("email"));
        txtEmail.sendKeys(email);
        WebElement txtPass = driver.findElement(By.id("passwd"));
        txtPass.sendKeys(password);
        WebElement btnSubmit = driver.findElement(By.id("SubmitLogin"));
        btnSubmit.click();
    }

//    @Test
//    public void Add_Customer_success() throws InterruptedException {
//        String testCase = "AddCus_01";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        JavascriptExecutor executor =  (JavascriptExecutor)driver;
//        executor.executeScript("window.scroll(0, document.body.scrollHeight)");
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_FIRSTNAME), "Customer name must not be blank");
//    }
//
//    @Test
//    public void add_customer_fail() throws InterruptedException {
//        String testCase = "AddCus_02";
////        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
////        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
////        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_FIRSTNAME), "Special characters are not allowed");
//
//    }
//
//    @Test
//    public void AddCus_03() throws InterruptedException {
//        String testCase = "AddCus_03";
////        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
////        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
////        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_FIRSTNAME), "Numbers are not allowed");
//    }
//
//    @Test
//    public void AddCus_04() throws InterruptedException {
//        String testCase = "AddCus_04";
////        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
////        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
////        Thread.sleep(2000);
////        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_LASTNAME), "Customer name must not be blank");
//    }

//    @Test
//    public void AddCus_05() throws InterruptedException {
//        String testCase = "AddCus_05";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_LASTNAME), "Special characters are not allowed");
//    }
//
//    @Test
//    public void AddCus_06() throws InterruptedException {
//        String testCase = "AddCus_06";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_LASTNAME), "Numbers are not allowed");
//    }
//
//    @Test
//    public void AddCus_07() throws InterruptedException {
//        String testCase = "AddCus_07";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_EMAIL), "Email-ID must not be blank");
//    }
//
//    @Test
//    public void AddCus_08() throws InterruptedException {
//        String testCase = "AddCus_08";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_EMAIL), "Email-ID is not valid");
//    }
//
//    @Test
//    public void AddCus_09() throws InterruptedException {
//        String testCase = "AddCus_09";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_ADDRESS), "Address Field must not be blank");
//    }
//
//    @Test
//    public void AddCus_10() throws InterruptedException {
//        String testCase = "AddCus_10";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_ADDRESS), "Special characters are not allowed");
//    }
//
//    @Test
//    public void AddCus_11() throws InterruptedException {
//        String testCase = "AddCus_11";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        addCustomerActions.clickToSubmit();
//        driver.switchTo().alert().accept();
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_MOBILE), "Mobile no must not be blank");
//    }
//
//    @Test
//    public void AddCus_12() throws InterruptedException {
//        String testCase = "AddCus_12";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_MOBILE), "Characters are not allowed");
//    }
//
//    @Test
//    public void AddCus_13() throws InterruptedException {
//        String testCase = "AddCus_13";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.MESS_MOBILE), "Special characters are not allowed");
//    }
//
//    //success
//    @Test
//    public void AddCus_14() throws InterruptedException {
//        String testCase = "AddCus_14";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        addCustomerActions.clickToSubmit();
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.TITLE_ADDCUSTOMER_ACCESS), "Access Details to Guru99 Telecom");
//    }
//
//    @Test
//    public void AddCus_15() throws InterruptedException {
//        String testCase = "AddCus_15";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        addCustomerActions.clickToSubmit();
//        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals(alert.getText(), "please fill all fields");
//        alert.accept();
//    }
//
//    @Test
//    public void AddCus_16() throws InterruptedException {
//        String testCase = "AddCus_16";
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        addCustomerActions.readData(testCase);
//        addCustomerActions.clickToReset();
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.TXT_FIRSTNAME), "");
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.TXT_LASTNAME), "");
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.TXT_EMAIL), "");
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.TXT_ADDRESS), "");
//        Assert.assertEquals(addCustomerActions.getTextOfElement(driver, AddCustomerUI.TXT_MOBILE), "");
//    }
//
//    @Test
//    public void AddCus_17() throws InterruptedException {
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        Thread.sleep(2000);
//        boolean radio_Done = addCustomerActions.getSelected(driver, AddCustomerUI.RADIO_DONE);
//        System.out.println(radio_Done);
//        boolean radio_Pending = addCustomerActions.getSelected(driver, AddCustomerUI.RADIO_PENDING);
//        System.out.println(radio_Pending);
//        Assert.assertFalse(radio_Done);
//        Assert.assertFalse(radio_Pending);
//    }

//    @Test
//    public  void AddCus_18() {
//        addCustomerActions.clickToElement(driver, AddCustomerUI.MENU_DROP);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
//        addCustomerActions.clickToElement(driver, AddCustomerUI.RADIO_DONE);
//        Assert.assertFalse(addCustomerActions.getSelected(driver, AddCustomerUI.RADIO_PENDING));
//    }

}
