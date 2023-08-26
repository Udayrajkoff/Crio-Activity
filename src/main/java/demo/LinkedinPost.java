package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class LinkedinPost {
    ChromeDriver driver;
    public LinkedinPost()
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

    public void LinkedinPost() throws InterruptedException{
        // Navigate to Linkedin site  URL:https://www.linkedin.com/feed/
        driver.get("https://www.linkedin.com/feed/");


        // Click on "Sign in" Using Locator "Link Text" Sign in.click()
        driver.findElement(By.linkText("Sign in")).click();


        // Enter user name in username field Using Locator "XPath" //input[@id='username'].sendKeys("udayrakoff@gmail.com")
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("udayrajkoff@gmail.com");
        // Enter password in password field Using Locator "XPath" //input[@id='password'].sendKeys("")
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Deekshith@159");
        // Click on "Sign in" button Using Locator "XPath" //button[@type='submit'].click()
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        // Click on "Who's viewed your profile" Using Locator "XPath" //a[@href='/me/profile-views/'].click()
        driver.findElement(By.xpath("//a[@href='/me/profile-views/']")).click();
        // Find the element of the count Using Locator "Class" Name text-body-medium-bold pr1 text-heading-large
        Thread.sleep(2000);
        WebElement count = driver.findElement(By.xpath("//p[contains(@class, 'pr1')]"));
        // Get the text of the count  count.getText()
        System.out.println(count.getText());
        // Click on "Impressions of your post" Using Locator "XPath" //a[@href='/me/profile-views/']
        // Find the element of the count Using Locator "Class" Name text-body-medium-bold pr1 text-heading-large
        // Get the text of the count  count.getText()

        // Find the element for Home button and click on it Using Locator "XPath" //span[text()='Home'].click
        driver.findElement(By.xpath("//span[text()='Home']")).click();


        // Click on "Start a post" Using Locator "xpath" //span[@class='display-flex align-items-center'].click()
        driver.findElement(By.xpath("//span[@class='display-flex align-items-center']")).click();

        Thread.sleep(3000);
                
        // Enter "Connections only" Using Locator "xpath" //div[@class='ql-editor ql-blank'].sendKey("Connections only")
        // Set<String> windowHandles = driver.getWindowHandles();
        // for(String handle : windowHandles){
        //     driver.switchTo().window(handle);
        // }
        
        driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("Connections only");
        // Click on "Post" button Using Locator "xpath" //span[text()='Post'].click()
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);
        
        // driver.switchTo().window(windowHandles.iterator().next());
        
        // Validate the post Using Locator "XPath" //a[text()='View post'].click()
        driver.findElement(By.xpath("//a[text()='View post']")).click();
        Thread.sleep(3000);
        // get text of the post  text.getText()
        boolean textPost = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div/div[2]/div/div/main/div/section/div/div/div[4]/div/div/span/span")).isDisplayed();
        System.out.println("Post Conntection only posted? : " + textPost);
   }
    
}
