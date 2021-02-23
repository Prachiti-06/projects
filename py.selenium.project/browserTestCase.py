
from selenium import webdriver

#from webdriver_manager.chrome import ChromeDriverManager
# install driver manager python -m pip install "webdriver-manager==2.3"
#driver = webdriver.Chrome(ChromeDriverManager("2.3").install())

#create option for chrome browser
#option = webdriver.ChromeOptions()
#option.add_argument("headless")

base_url="https://www.amazon.in"

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

# to close the browser
driver.close()