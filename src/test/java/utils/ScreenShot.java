package utils;

import core.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import test.TC_AddCustomer;

import java.io.File;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends BaseTest {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public static void captureScreenshot(WebDriver driver,String screenshotName) {
        try {
            TakesScreenshot ts = ((TakesScreenshot) driver);
            // Tạo tham chiếu của TakesScreenshot
            //TakesScreenshot ts = (TakesScreenshot) driver;
            // Gọi hàm capture screenshot - getScreenshotAs
            File source = ts.getScreenshotAs(OutputType.FILE);
            // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder
            File theDir = new File("./screenshots/");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình. Giống reflect Method
            FileHandler.copy(source, new File("./screenshots/" + screenshotName + "_" + dateFormat.format(new Date()) + ".png"));
           // System.out.println("Screenshot success: " + result.getName());
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
}
