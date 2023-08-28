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


public class IMDBRating {
    ChromeDriver driver;
    public IMDBRating(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest(){
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void IMDBRating() throws InterruptedException{
        // Navigate to IMDB URL  URL:https://www.imdb.com/chart/top/
        driver.get("https://www.imdb.com/chart/top/");
        // Find the highest rated movie element Using Locator "XPath" //div/ul/li[1]/div[2]/div/div/div[1]/a/h3
        WebElement HighestRatedMovie = driver.findElement(By.xpath("//div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
        // Get the text of the element
        String movieName = HighestRatedMovie.getText();
        System.out.println("Highest rated movie in IMDB is: " + movieName);

        // Get count movies included in the table Using Locator "Tag Name" ul and li
        List<WebElement> countOfMovies = driver.findElements(By.xpath("//li[@class='ipc-metadata-list-summary-item sc-bca49391-0 eypSaE cli-parent']"));
        System.out.println("Count of movies in IMDB site is: " + countOfMovies.size());

        // Get the oldest movie Using Locator "XPath" //div[contains(@class, 'cli-children')]/div/a/h3[1]
        Select sort = new Select(driver.findElement(By.id("sort-by-selector")));
        sort.selectByVisibleText("Release date");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(2000);
        
        WebElement oldestMovie = driver.findElement(By.xpath("//div[contains(@class, 'cli-children')]/div/a/h3[1]"));
        System.out.println("Oldest movie name in IMDB is: " + oldestMovie.getText());
        
        // Get the most recent movie Using Locator "XPath" //div[@class='sc-b85248f1-5 kZGNjY cli-title-metadata']/span[1]4
        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(4000);

        WebElement LatestMovie = driver.findElement(By.xpath("//div[contains(@class, 'cli-children')]/div/a/h3[1]"));
        System.out.println("Oldest movie name in IMDB is: " + LatestMovie.getText());
        
        // Find out which movie has most user ratings Using Locator "XPath" //span[@class='ipc-rating-star--voteCount']
        Select sort2 = new Select(driver.findElement(By.id("sort-by-selector")));
        sort2.selectByVisibleText("Number of ratings");
        Thread.sleep(2000);
        WebElement UserRating = driver.findElement(By.xpath("//div[contains(@class, 'cli-children')]/div/a/h3[1]"));
        System.out.println("Most user rating movie is: " + UserRating.getText());

    }
}
