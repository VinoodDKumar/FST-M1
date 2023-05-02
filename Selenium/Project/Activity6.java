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

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void Jobs(){
        driver.get("https://alchemy.hguy.co/jobs");
        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
        driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("Banking");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/div[1]/h3[1]"))
                .click();
        driver.findElement(By.xpath("//input[@type='button']")).click();
        String email = driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
        System.out.println("email : "+email);
        Assert.assertEquals(email,"abc@gmail.com");
    }
    @AfterClass
    public void close(){

        driver.quit();
    }
}
