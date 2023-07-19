#import drivers
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as Firefoxservice
from selenium.webdriver.support import expected_conditions, select
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# driver setup
service = Firefoxservice(GeckoDriverManager().install())
#Start driver
with webdriver.Firefox(service=service) as driver:
    #open url
    driver.get("https://alchemy.hguy.co/jobs")
    #get the title
    print(driver.title)
    #Navigate to Post job
    driver.find_element(By.XPATH,"/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a").click()
    #Fill in the company details page
    #Your email
    driver.find_element(By.ID,"create_account_email").send_keys("abc1238372489@gmail.com")
    #Job title
    driver.find_element(By.ID,"job_title").send_keys("Manual testing")
    #Job location
    driver.find_element(By.ID,"job_location").send_keys("London")
    #Job type
    sel=Select(driver.find_element(By.ID,"job_type"))
    sel.select_by_value("Full Time")
    #Description
    driver.find_element(By.ID,"job_description_ifr").send_keys("Job description")
    #Application email/URL
    driver.find_element(By.ID,"application").send_keys("http://abc.com")
    #company name
    driver.find_element(By.ID,"company_name").send_keys("IBM")
    #Click Preview
    driver.find_element(By.XPATH,"/html/body/div[1]/div/div/div/main/article/div/form/p/input[4]").click()
    #Submit listing
    driver.find_element(By.ID,"job_preview_submit_button").click()
    #Navigate to jobs
    driver.find_element(By.XPATH,"/html/body/div[2]/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a").click()
    #search keywords
    driver.find_element(By.ID,"search_keywords").send_keys("Manual testing")
    #Search
    driver.find_element(By.XPATH,"/html/body/div[2]/div/div/div/main/article/div/div/form/div[1]/div[4]/input").click()

    #Close the browser
    driver.quit();
