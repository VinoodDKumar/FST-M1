#import drivers
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager

# driver setup
service = Firefoxservice(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs")
    pagetitle=driver.title
    print("Page title: ",pagetitle)
    heading1=driver.find_element(By.XPATH,"/html/body/div/div/div/div/main/article/header/h1").text
    print(heading1)
    #Assertion
    assert (heading1,"Welcome to Alchemy Jobs")
    #Close browser
    driver.quit()
