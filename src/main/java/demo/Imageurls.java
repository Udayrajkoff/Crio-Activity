package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class Imageurls {
    ChromeDriver driver;
    public Imageurls()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void Imageurls() throws InterruptedException{
        try {
            driver.get("https://in.bookmyshow.com/explore/home/chennai");
            
            List<WebElement> urlsOfimage = driver.findElements(By.xpath("//div/div[2]/div/img"));
            Thread.sleep(3000);
            for(WebElement imgElement : urlsOfimage){
                System.out.println("List of image url: " + imgElement.getAttribute("src"));
            }

            //<-- This site is blocked by client not to automate -->

            //  Thread.sleep(3000);
		    // JavascriptExecutor js = (JavascriptExecutor)driver;
		    // js.executeScript("window.scrollBy(0,1000)", "");
		    // Thread.sleep(10000);
            
            // List<WebElement> PremiereTitle = driver.findElements(By.xpath("//div/div[3]/div[1]/div[@class='sc-7o7nez-0 iHsoLV']"));    
            // Thread.sleep(3000);
            // System.out.println("Premiere 2nd item name is: " + PremiereTitle.get(1));
            
            // WebElement PremiereLanguage = driver.findElements(By.xpath("//div/div[3]/div[2]/div[@class='sc-7o7nez-0 kHxEsI']")).get(1);
            // Thread.sleep(2000);
            // System.out.println("Premiere 2nd item language is: " + PremiereLanguage);            

                    
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
 
    }
    


