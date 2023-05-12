package alchemyProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test
    public void BackendLogin(){
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_pass")).sendKeys("p@ssw0rd");
        driver.findElement(By.id("wp-submit")).click();

        String pageTitle= driver.getTitle();
        System.out.println("Title of Page: "+pageTitle);
        Assert.assertEquals(pageTitle,"Dashboard ‹ Alchemy Jobs — WordPress");
    }
    @AfterClass
    public void close(){

        driver.quit();
    }
}
