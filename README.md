Exercise
Create a selenium-based test framework with the following specs:

* Code in Java
* Selenium Webdriver to interact with the application under test
* TestNG to run the tests
* TestNG to do the assertions
* A Page interactions layer (based on the Page-Object pattern but doesn't have to mimic any specific implementation)
* A Driver interactions layer  (so that the page interactions layer is not directly calling selenium methods)
* Framework will tests the google website (www.google.com)
* The following two tests:
  1. Do a search by typing in a keyword, 
     and make sure that the keyword appears on the results page
  2. Do a search by using the mouse to click letters inside the keyboard 'input tool'
     and make sure that the keyword appears on the results page



Readme:
1. in cmd - change directory to ….\google_Search\ folder
2. shared_resources\google_Search.bat
    Note: it might throw, TestNG main class cannot be found
     Fix: 
     1.	Open ….\rentalmatics_project\ folder (project) in eclipse 
     2.	Right click on Project > Properties > TestNG > uncheck 'use project TestNG jar' > Apply and Close

Nice to Have: also included shared_resources\ui_seleniumtest is a sample Jenkins file, to run tests in Jenkins as a pipeline job) 

Observation of tests:
	2 tests incuded in resultPageTest.java
	searchTest_sendkeys - assertions with send_keys input
	searchTest_mouse - assertions with mouse click from 'input tool'
	both tests perform same testng assertions on results page to check search_text appears on results page
 
