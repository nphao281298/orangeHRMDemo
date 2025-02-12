package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    String projecPath = System.getProperty("user.dir");
    private WebDriver driver;
    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        if (browser == BrowserList.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserList.CHROME){
            driver = new ChromeDriver();
        } else if (browser == BrowserList.EDGE){
            driver = new EdgeDriver();
        } else if (browser == BrowserList.SAFARI){
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost:5000/");
        driver.manage().window().maximize();
        return driver;
    }


    protected WebDriver getBrowserDriver(String browserName, String url){
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser){
            case FIREFOX :
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    public String getEmailRandom() {
        Random rand = new Random();
        return "John" + rand.nextInt(99999) + "@kennedy.us";
    }

    protected void closeBrowser(){
        if (!(driver == null)){
            driver.quit();
        }
    }

    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
