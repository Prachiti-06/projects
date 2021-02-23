from selenium import webdriver
from selenium.webdriver.common.keys import Keys
# declare variable to store the URL to be visited
base_url="https://www.amazon.de/"
search_term="books"

# chrome driver variable declaration and initialization
driver = webdriver.Chrome(executable_path="C:/chromewebdriver/chromedriver.exe") 
# maximize the browser window
driver.maximize_window()
# to enforce this setting we will use builtin implicitly_wait() function of our 'driver' object.
driver.implicitly_wait(10) #10 is in seconds
# to load a given URL in browser window
driver.get(base_url)
# test whether correct URL/ Web Site has been loaded or not
assert "Amazon" in driver.title
#accept the cookies settings
driver.find_element_by_name("accept").click()
# to enter search term, we need to locate the search textbox
searchTextBox=driver.find_element_by_id("twotabsearchtextbox")
# to enter the search term in the search textbox via send_keys() function
searchTextBox.send_keys(search_term)
# to search for the entered search term
searchTextBox.send_keys(Keys.RETURN)
# to verify if the search results page loaded
assert search_term in driver.title
# to verify if the search results page contains any results or no results were found.
assert "No results found." not in driver.page_source
# to close the browser
driver.close()