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
    #Assertion
    assert (pagetitle,"Alchemy Jobs – Job Board Application")
