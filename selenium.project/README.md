
# Automation Test Project
This project has designed to perform automation testing of a particular website using Selenium. This project has multiple test cases to test the search functionality of the website.

## Tools
* Selenium Webdriver

## Requirements

To use this project, need to install the following applications:
* Chrome browser and ChromeDriver
* Java 1.8
* Git

## Setup 
1.	Download the ChromeDriver for windows [OS](https://chromedriver.chromium.org/downloads).
2.	Download the latest version of selenium library for Java and extract it (https://www.selenium.dev/downloads/).
3.	Open the project and add all JAR files inside the libs folder of the project.
4.	Note down the chrome driver path from local and add the local path of ChromeDriver to System property in the program. 
`System.setProperty("webdriver.chrome.driver", "C:\\chromewebdriver\\chromedriver.exe")`
5.	Download Jars and add in Path or add maven dependencies.

## Command Required to run the Automation test
1. Using Selenium : `mvn test -Pselenium`
2. Using TestNG : `mvn test`