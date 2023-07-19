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
    driver.find_element(By.XPATH,"/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a").click()
    jobtitle=driver.title;
    print("Title: ",jobtitle)
    assert (jobtitle,"Jobs – Alchemy Jobs")
