package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchAmazon{
    ChromeDriver driver;
    public SearchAmazon()
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

    public  void SearchAmazon() throws InterruptedException{
        // Navigate to google page  URL: www.google.com
        driver.get("https://www.google.com/");
        // Search for amazon in the search bar Using Locator "XPath" //*[@name='q'].sendKeys("amazon")
        driver.findElement(By.name("q")).sendKeys("amazon");
        
        // Hit enter Using Locator "XPath" //*[@name='q'].sendKeys("amazon")
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        // Validate the url of amazon.in Using Locator "XPath" //span[contains(text(),'Amazon.in'] or [contains(text(),'Amazon.com']
        boolean result = driver.findElement(By.xpath("//span[contains(text(),'Amazon.in') or contains(text(),'Amazon.com')]")).isDisplayed();
        Thread.sleep(2000);
        System.out.println("amazon.in or amazon.com link is " + result);
        
    }

}