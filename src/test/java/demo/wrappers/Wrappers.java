package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Wrappers {
    
    /*
     * Write your selenium wrappers here
     */
   static String url = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";
  
     public static boolean navigatToUrl(WebDriver driver){
        try {
            if(driver.getCurrentUrl().equals(url)){
                System.out.println("Already at the desired Page");
                return true;
            }else{
                driver.get(url);
                System.out.println("Navigated to the google forms Page");
                return driver.getCurrentUrl()==url;
            }
        } catch (Exception e) {
            System.out.println("Exception Occured");
            e.getStackTrace();
            return false;
        }

     }

     public static boolean verifyThePage(WebDriver driver, String PageName){

        try {
            if(driver.getCurrentUrl().contains(PageName)){
                System.out.println("Page is verified");
                return true;
            }else{
                System.out.println("Page is not verified");
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Exception Occured");
            e.getStackTrace();
            return false;
        }
     }

     public static boolean advanceClick(WebDriver driver, WebElement element){
        try {
            if(element.isDisplayed()){
                if(element.isEnabled()){
                    JavascriptExecutor js = ((JavascriptExecutor)driver);
                    js.executeAsyncScript("arguments[0].scrollIntoView(true);", element);
                    element.click();
                    System.out.println("Element is clicked successfully");
                    return true;
                }else{
                    System.out.println("Element is not Enabled");
                    return false;
                }
            }else{
                System.out.println("Element is not Displayed");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
     }

     public static boolean sendText(WebElement element, String sendKey){
         try {
            element.clear();
            element.sendKeys(sendKey);
            System.out.println("Crio Learner is filled Successfully");
            return true;
         } catch (Exception e) {
            System.out.println("Exception Occured");
            e.getStackTrace();
            return false;
         }
     }

     public static boolean verifyText(WebElement element, String text){
        try {
            if(element.getAttribute("data-initial-value").contains(text)){
                System.out.println(element.getAttribute("data-initial-value"));
                System.out.println("Text is verified Succefully");
                return true;
            }else{
                System.out.println("Text is not verified");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception Occured");
            e.getStackTrace();
            return false;
        }
     }

    public static boolean sendTextWithTime(WebElement practicingAutomation, String text) {
        // TODO Auto-generated method stub
        try {
            long timeStamp = System.currentTimeMillis()/1000;
            practicingAutomation.sendKeys(text+timeStamp);
            return true;
        } catch (Exception e) {
            System.out.println("Exception Occured");
            e.getStackTrace();
            return false;
        }
    }

    public static void addexperience(WebDriver driver,String n) {
       try {
        List<WebElement> experinceElements = driver.findElements(By.xpath("//div[@class=\"nWQGrd zwllIb\"]/label/div/div[2]/div/span"));
        for(WebElement e : experinceElements){
            if(e.getText().contains(n)){
                e.click();
                System.out.println("Experince is selected succesfully");
                Thread.sleep(1000);
            }
               
        }
       } catch (Exception e) {
        System.out.println("Exception Occured");
        e.getStackTrace();
       }
    }

    public static void selectTools(WebDriver driver, String tool) {
        try {
            List<WebElement> tools = driver.findElements(By.xpath("//span[@class='aDTYNe snByac n5vBHf OIC90c']"));
            for(WebElement e: tools){
                if(e.getText().contains(tool)){
                    e.click();
                    System.out.println(tool+" is selected Succesfully");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception Occured");
            e.getStackTrace();
        }
    }

    public static void selectAdress(WebDriver driver, String text) {
       try {
        List<WebElement> adressOptions = driver.findElements(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']/div/span"));
        for(WebElement e: adressOptions){
            if(e.getText().equalsIgnoreCase(text)){
                e.click();
                System.out.println("Adressed is selected sucessfully");
            }
        }
       } catch (Exception e) {
        System.out.println("Exception Occured");
        e.getStackTrace();
       }
    }

    public static void date(WebDriver driver) {
        try {
            Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date previousDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = dateFormat.format(previousDate);
        WebElement date = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));
        date.sendKeys(formatedDate);
        } catch (Exception e) {
            System.out.println("Exception Occured");
            e.getStackTrace();
        }

    }

    public static void time(WebDriver driver) {
       try {
        Calendar cal = Calendar.getInstance();
        // int hours = cal.get(Calendar.HOUR);
        // int minutes = cal.get(Calendar.MINUTE);
        WebElement timeHr = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(timeHr));
        timeHr.sendKeys("07");
        WebElement timeMin = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        wait.until(ExpectedConditions.visibilityOf(timeMin));
        timeMin.sendKeys("30");
       } catch (Exception e) {
        // TODO: handle exception
       }
    }

    public static void clickOnSubmitButton(WebDriver driver) {
        try {
            WebElement SubmitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
        SubmitButton.click();
        } catch (Exception e) {
            System.out.println("Exception Occured");
            e.getStackTrace();
        }
    }
   


    public static void successMessage(WebDriver driver) {
        WebElement getText = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        String text = getText.getText();
        System.out.println(text);
            if(text.contains("Thanks for your response")){
            System.out.println("Got the Response");
        }else{
            System.out.println("Didn't get the Response");
        }

    }
}
