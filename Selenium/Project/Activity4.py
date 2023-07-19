#import drivers
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager

# driver setup
service = Firefoxservice(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs")
    print("Page title: ",driver.title)
    heading2=driver.find_element(By.XPATH,"/html/body/div/div/div/div/main/article/div/h2").text
    print(heading2)
    #Assertion
    assert (heading2,"Quia quis non")
    #Close browser
    driver.quit()
