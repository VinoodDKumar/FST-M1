package alchemyProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
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
        String webpageHeading = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        System.out.println(webpageHeading);

        Assert.assertEquals(webpageHeading,"Welcome to Alchemy Jobs");
        String title = driver.findElement(By.xpath("//article[@id='post-16']//img")).getAttribute("src");
        System.out.println(title);
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}