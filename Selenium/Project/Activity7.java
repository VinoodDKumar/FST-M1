package alchemyProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test
    public void jobs(){
        driver.get("https://alchemy.hguy.co/jobs");
        driver.findElement(By.xpath("//a[contains(text(),'Post a Job')]")).click();
        driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys("vinod3219@gmail.com");
        driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys("test analyst");
        Select jobType = new Select(driver.findElement(By.id("job_type")));
        jobType.selectByVisibleText("Full Time");
        driver.findElement(By.xpath("//input[@id='application']")).sendKeys("http://ibm.com");
        driver.findElement(By.xpath("//body[@id='tinymce']//p")).sendKeys("N/A");
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@id='company_website']")).sendKeys("http://xyz.com");
        driver.findElement(By.xpath("//input[@id='company_tagline']")).sendKeys("Balance work");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/form[1]/p[1]/input[4]")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.id("job_preview_submit_button")).click();

        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
        driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("test analyst");
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}