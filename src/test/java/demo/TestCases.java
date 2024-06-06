package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import dev.failsafe.internal.util.Durations;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @Test
    public void testCase01() throws InterruptedException{  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Wrappers.navigatToUrl(driver);
        Wrappers.verifyThePage(driver, "forms");
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement NameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd\"]/div/div/div/input")));
        Wrappers.sendText(NameElement, "Crio Learner");
        Wrappers.verifyText(NameElement, "Crio Learner");
        WebElement practicingAutomation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@class='KHxj8b tL9Q4c']")));
        Wrappers.sendTextWithTime(practicingAutomation, "I want to be the best QA Engineer!");
        Wrappers.verifyText(practicingAutomation,"I want to be the best QA Engineer!");
        Wrappers.addexperience(driver,"3 - 5");
        Wrappers.selectTools(driver,"Java");
        Wrappers.selectTools(driver,"Selenium");
        Wrappers.selectTools(driver,"TestNG");
        WebElement addressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']")));
        addressElement.click();
        Thread.sleep(1000);
        Wrappers.selectAdress(driver, "Mr");
        Thread.sleep(1000);
        Wrappers.date(driver);
        Thread.sleep(1000);
        Wrappers.time(driver);
        Wrappers.clickOnSubmitButton(driver);
        Thread.sleep(1000);
        Wrappers.successMessage(driver);
    }

    // @AfterTest
    // public void endTest()
    // {
    //     driver.close();
    //     driver.quit();

    // }
}