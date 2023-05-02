package alchemyProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void SecondHeading(){
        driver.get("https://alchemy.hguy.co/jobs");
        String heading = driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]")).getText();
        System.out.println("Second Heading : "+heading);
        String text = "Quia quis non";

        Assert.assertEquals(heading,text);
    }
    @AfterClass
    public void close(){

        driver.quit();
    }
}
