package selenium_java_activity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9_java {
    WebDriver driver;

    WebDriverWait wait;
    @BeforeClass
    public void login(){
        //login application
        String url="https://alchemy.hguy.co/jobs/wp-admin";
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver= new FirefoxDriver();
        driver.get(url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void createJobListing() {
        //login user
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        //select job listings
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[2]")).click();
        //Add new item
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
        //Fill in new item
        driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")).sendKeys("Test Engineer");
        driver.findElement(By.id("_company_website")).sendKeys("http://abc.com");
        driver.findElement(By.id("_job_location")).sendKeys("London");
        driver.findElement(By.id("_company_name")).sendKeys("IBM");
        driver.findElement(By.id("_company_twitter")).sendKeys("@IBM");
        driver.findElement(By.id("_company_tagline")).sendKeys("Tagline");
        driver.findElement(By.id("_job_expires")).sendKeys("April 20, 2023");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")));
        driver.findElement(By.id("inspector-checkbox-control-1")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")).click();
        System.out.println(driver.getTitle());
    }
    @AfterClass
    public void closeBrowser(){

        driver.quit();
    }

}
