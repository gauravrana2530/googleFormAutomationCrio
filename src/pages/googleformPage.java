package demo;

import org.openqa.selenium.WebDriver;

public class googleformPage {

    WebDriver driver;

    public googleformPage(WebDriver driver){
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
        PageFactory.initElements(factory, this);
    }

    



}