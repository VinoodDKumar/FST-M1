package alchemyProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void pageTitle(){
        driver.get("https://alchemy.hguy.co/jobs");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        Assert.assertEquals(pageTitle,"Alchemy Jobs – Job Board Application");
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}