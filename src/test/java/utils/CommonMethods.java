package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void clickAbility(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        clickAbility(element);
        element.click();
    }

    public static void selectDropDawn(WebElement element, String value) {
        Select ss = new Select(element);
        ss.selectByVisibleText(value);
    }

    public static void selectDropDawn(WebElement element, int index) {
        Select ss = new Select(element);
        ss.selectByIndex(index);
    }

    public static void alertForAccept() {
        Alert a = driver.switchTo().alert();// alerts for pop ups
        a.accept();
    }

    public static void alertForDismiss() {
        Alert a = driver.switchTo().alert();// alerts for pop ups
        a.dismiss();
    }

    public static void alertForSendText(String text) {
        Alert a = driver.switchTo().alert();// alerts for pop ups
        a.sendKeys(text);
    }

    public static void alertForGetText() {
        Alert a = driver.switchTo().alert();// alerts for pop ups
        a.getText();
    }
    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH + fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

     public static void clickRadioButton (WebElement element){
        if (element.isEnabled()){
            if(!element.isSelected()){
                element.click();
            }
        }
     }

}