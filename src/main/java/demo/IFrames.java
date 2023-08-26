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
import org.w3c.dom.Text;

public class IFrames {
    ChromeDriver driver;
    public IFrames(){
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

    public void IFrames(){
        // Navigate to url  URL :https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Switch to top frame and then switch to left frame and get text Using Locator "XPath" //body
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        WebElement ElemoffLeftFrame = driver.findElement(By.xpath("//body"));
        // Get text of left frame  .getText()
        String TextofLeftFrame = ElemoffLeftFrame.getText();
        System.out.println("Text for left frame is: " + TextofLeftFrame);
        // Switch to parent frame and then switch to middle frame and get Text Using Locator "XPath" .getText()
        driver.switchTo().parentFrame();
        
        driver.switchTo().frame("frame-middle");
        // Get text of middle frame  .getText()
        WebElement ElemofMiddleFrame = driver.findElement(By.id("content"));
        String TextofMiddleFrame = ElemofMiddleFrame.getText();
        System.out.println("Text for middle frame is: " + TextofMiddleFrame);

        // Switch to parent frame and then switch to right frame and get Text Using Locator "XPath" //body
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");

        WebElement ElemofRightFrame = driver.findElement(By.xpath("//body"));
        
        // Get text of right frame  .getText()
        String  TextofRightFrame = ElemofRightFrame.getText();
        System.out.println("Text for right frame is: " + TextofRightFrame);

        // Switch to parent frame and switch to default frame then switch to bottom frame and get text Using Locator "XPath" //body
        driver.switchTo().parentFrame();
        
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");

        WebElement ElemofBottomFrame = driver.findElement(By.xpath("//body"));
        
        // Get text of bottom frame  .getText()
        String TextofBottomFrame = ElemofBottomFrame.getText();
        System.out.println("Text for bottom frame is: " + TextofBottomFrame);

        driver.switchTo().defaultContent();
    }

}
