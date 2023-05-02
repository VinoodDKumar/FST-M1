package alchemyProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
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
        String title = driver.findElement(By.xpath("//article[@id='post-16']//img")).getAttribute("src");
        System.out.println("URL of the header image : "+title);

        Assert.assertEquals(driver.findElement(By.xpath("//article[@id='post-16']//img")).getAttribute("scr"),title);
    }

    @AfterClass
    public void close(){

        driver.quit();
    }
}
