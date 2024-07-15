# FinalProject
# Author - Victoria Pashkova

# Project for expert-sport.by - website for a chain of sports nutrition and health supplement stores

# Project structure:

# pages:
## BasePage - created for WebDriver
## HomePage - selectors, constructors and methods on the Home page (extends BasePage)
## CartPage - selectors, constructors and methods on the Cart page (extends BasePage)
## LoginPage - selectors, constructors and methods on the Login page (extends BasePage)
## SearchPage - selectors, constructors and methods on the Search page (extends BasePage)
# listeners:
## TestListeners - created listeners with LOGGERs
## ElementActionListener - created listeners for actions
# model:
## User - created User model
# tests:
## BaseTest - created for Before- and AfterMethod for UI tests
## SportExpertTests - created for UI tests
## LoginTest - created for login tests
## BaseApiTest - created for setUp API tests
## ApiTest - created for API tests
# resources:
## allure properties - to specify settings for the Allure report
## json resources - to use json parameters in UI test
## suites resources - to create two .xml files for UI and API tests separately
## log4j2.properties - to specify settings for log4j2
# utils:
## DriverFactory - for Chrome and Firefox drivers
## ScreenshotUtils - for screenshots
## retry - created for retry failed tests, solving synchronization problems
## UserCreator - for create users

# browser parameter should be providet to maven or specifiet in configuration in order to run the tests