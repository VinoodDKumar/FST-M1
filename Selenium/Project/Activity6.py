#import drivers
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as Firefoxservice
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# driver setup
service = Firefoxservice(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    #open url
    driver.get("https://alchemy.hguy.co/jobs")
    #initialize wait
    wait=WebDriverWait(driver,30)
    pagetitle=driver.title
    #print page title
    print("Page title: ",pagetitle)
    #Navigate to Jobs
    driver.find_element(By.XPATH,"/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a").click()
    #Search for job
    driver.find_element(By.ID,"search_keywords").send_keys("Banking")
    driver.find_element(By.XPATH,"/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input").click()
    #Wait for search results
    wait.until(expected_conditions.visibility_of_element_located(By.XPATH,"/html/body/div/div/div/div/main/article/div/div/ul"))
    #select the job
    driver.find_element(By.XPATH,"/html/body/div/div/div/div/main/article/div/div/ul/li[1]/a").click()
    #Apply for job
    driver.find_element(By.XPATH,"/html/body/div/div/div/div/main/article/div/div/div/div[3]/input").click()
    #Print email id
    email=driver.find_element(By.XPATH,"/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p/a").text
    print("Email: ",email)
