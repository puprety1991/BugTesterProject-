package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.setHeadless(false);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html%22");
                driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement depDate = driver.findElement(By.xpath("//input[@id='first_date_picker']"));
        depDate.click();

        //get all the months
        boolean isFlag =  false;


        while (!isFlag) {
            WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
            System.out.println(month.getText());
            if (month.getText().equals("April")) {
                System.out.println(month.getText());
                List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
                for (WebElement date : dates) {
                    System.out.println(date.getText());
                    if (date.getText().equals("15")) {
                        date.click();
                        isFlag = true;
                        break;
                    }
                }
            }
            if (!isFlag) {
                WebElement nextBtn = driver.findElement(By.xpath("//*[text()='Next']"));
                nextBtn.click();
            }


        }
    }

    }