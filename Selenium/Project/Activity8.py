#import drivers
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as Firefoxservice
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
    #Assertions
    login=driver.title
    print(login)
    assert login=="Dashboard ‹ Alchemy Jobs — WordPress"
    #close browser
    driver.quit()
