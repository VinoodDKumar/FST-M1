#import drivers
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as Firefoxservice
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# driver setup
service = Firefoxservice(GeckoDriverManager().install())
#Start driver
with webdriver.Firefox(service=service) as driver:
    #open url
    driver.get("https://alchemy.hguy.co/jobs/wp-admin")
    #get the title
    print(driver.title)
    #Enter username
    driver.find_element(By.ID,"user_login").send_keys("root")
    #Enter password
    driver.find_element(By.ID,"user_pass").send_keys("pa$$w0rd")
    #Login
    driver.find_element(By.ID,"wp-submit").click()
    #Locate Job listing
    driver.find_element(By.XPATH,"/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[2]").click()
    #Locate Add new button
    driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a").click()
    #Add new jobs
    driver.find_element(By.ID,"post-title-0").send_keys("Tester")
    #Fill in job details
    driver.find_element(By.ID,"_application").send_keys("abhiram@cklabs.com")
    driver.find_element(By.ID,"_job_location").send_keys("London")
    driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]").click()
    #Wait
    wait = WebDriverWait(driver, 10);
    wait.until(expected_conditions.visibility_of_element_located(By.XPATH,"/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]"))
    driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button").click()
    #driver.find_element(By.ID,"_company_name").send_keys("IBM")
    #Assertions
    driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a").click()
    job=driver.title
    assert job=="Alchemy Jobs Job Board Application "

    #Close browser
    driver.quit()
