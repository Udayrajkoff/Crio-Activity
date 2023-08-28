package demo;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;


public class WindowHandle {
    ChromeDriver driver;
    public WindowHandle(){
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

    public static void takeScreenshot(WebDriver driver, String screenshotType, String description){
        try {
            File theDir = new File("screenshots");
            if(!theDir.exists()){
                theDir.mkdirs();
            }

            String timestamp = String.valueOf(java.time.LocalDateTime.now());
            String filename = String.format("screenshot_%s_%s_%s.png", timestamp, screenshotType, description);

            TakesScreenshot scrshot = ((TakesScreenshot) driver);
            File SrcFile = scrshot.getScreenshotAs(OutputType.FILE);

            File DestFile = new File(theDir, filename);
            FileUtils.copyFile(SrcFile, DestFile);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WindowHandle(){
        // Navigate W3 school url  URL:https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        // Switch to frame and by the element of Try it button and click on it Using Locator "XPath" //button[text()='Try it'].click
        driver.switchTo().frame("iframeResult");

        // Using window handles switch to new window and get the title,  url and take screenshot  //button[text()='Try it'].click
        
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindowHandle =driver.getWindowHandle();

        for(String handle : windowHandles){
            if(!handle.equals(originalWindowHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }

        takeScreenshot(driver, "newWindow", "Full Screenshot");

        String newWindowTitle = driver.getTitle();
        String newWindowURL = driver.getCurrentUrl();
        
        System.out.println(newWindowTitle);
        System.out.println(newWindowURL);
       
        // Close the new window  
        driver.close();
        
        // Switch to main window  
        driver.switchTo().window(originalWindowHandle);
    } 
    
}
