package SeleniumPractice;

import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import io.cucumber.plugin.event.Node;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.CommonMethods;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.setHeadless(false);
        WebDriver driver=new ChromeDriver(chromeOptions);

        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Faccounts.google.com%2FManageAccount%3Fnc%3D1&parent_directed=true&flowName=GlifWebSignIn&flowEntry=SignUp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String baseWindow=driver.getWindowHandle();
        System.out.println(baseWindow);
        WebElement helpLink=driver.findElement(By.xpath("//*[text()='Help']"));
        helpLink.click();
        Set<String> multipleWindow=driver.getWindowHandles();
        Iterator<String> iterator = multipleWindow.iterator();
       String helpWindow="";
        while (iterator.hasNext()){
            String nextWindow = iterator.next();
            if (!baseWindow.equals(nextWindow)){
                driver.switchTo().window(nextWindow);

              String getTitle=driver.getTitle();
             if(getTitle.equals("Google Account Help")){
                 System.out.println(getTitle);
             }
        helpWindow=driver.getWindowHandle();

            }
        }
        driver.switchTo().window(baseWindow);
        Thread.sleep(5000);
        driver.switchTo().window(helpWindow);

    }
}
