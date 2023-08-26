package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bookmyshow {
    ChromeDriver driver;
    public Bookmyshow()
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

    public void Bookmyshow() throws InterruptedException{
    //     Navigate to bookmyshow page  URL:https://in.bookmyshow.com/explore/home/chennai
    driver.get("https://in.bookmyshow.com/explore/home/chennai");
    //     Find the list of links with variable ListOfLinks Using Locator "Tag Name" a
    List<WebElement> list = driver.findElements(By.tagName("a"));
    //     Count of links  list.size()        
    Thread.sleep(3000);   
    System.out.println(list.size());
    }
    
}
