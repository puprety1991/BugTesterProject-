package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class getLink {
    public static void main(String[] args) throws IOException {


        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.setHeadless(true);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(" https://www.airbnb.com/a/discover/?account_id=142001799&campaign_id=380403558&ad_id=80951606671905&ad_group_id=1295224921606272&keyword_id=kwd-80951688896370:loc-190&device=c&c=.pi2.pk380403558_1295224921606272&ghost=true&msclkid=c78b38b3636b1d736e8a5c9cec441aee&utm_source=bing&utm_medium=cpc&utm_campaign=USA%3ADTM%3ABRD%3AAIRBNB%5BEXACT%5D&utm_term=airbnb&utm_content=Airbnb%3AGeneric%2BExact");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            System.out.println(link.getText());
            String linkText = link.getAttribute("href");
            if (linkText != null) {
                URL obj = new URL(linkText);
                HttpURLConnection conn = ((HttpURLConnection)
                        obj.openConnection());
                int rCode = conn.getResponseCode();
                if (rCode == 200) {
                    System.out.println(i + " Link is valid------" + linkText);
                } else {
                    System.out.println(i + " Link is broken------" + linkText);
                }
            } else {
                System.out.println(links.get(i).getText());
                System.out.println(i + " Link is broken ********" + linkText);
            }

        }

    }
}