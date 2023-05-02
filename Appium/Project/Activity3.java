package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static Examples.Actionsbase.doSwipe;

public class Activity3 {
    WebDriverWait wait;
    AndroidDriver driver;

    public void setup() throws MalformedURLException, NullPointerException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Andriod");
        options.setAutomationName("UiAutomater2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("org.chromium.chrome.browser.ChromeTabbedActivity");
        options.noReset();

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void webappTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();
        //Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(
                "//android.view.View")));

        //Scroll to end by setting the start and end ponits
        Point start = new Point((int)(dims.width * 0.5), (int)(dims.height * 0.9));
        Point end = new Point((int)(dims.width * 0.5), (int)(dims.height * 0.6));

        doSwipe(driver, start, end, 100);

        //locate element and click it
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
                "//android.widget.Textview[contains(@text,'To-Do List')]"))).click();

        //wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
                "//android.widget.EditText[@resource-id='taskInput']")));

        //Find elememts on the page
        WebElement addTaskInput = driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath(
                "//android.widget.Button[@text='Add Task']"));
        //Enter tasks
        addTaskInput.sendKeys("Add tasks to list");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Get number of tasks");
        addTaskButton.click();
        Thread.sleep(1000);

        //clear the list
        driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[contains(@text, 'Clear List')]")).click();

        //Assertion
        List<WebElement> tasksadded = driver.findElements(AppiumBy.xpath(
                "//android.view.View[@resource-id='taskInput'']"));
        Assert.assertEquals(tasksadded.size(), 0);
    }

    @AfterClass
    public void afterclass() {
        driver.quit();
    }
}