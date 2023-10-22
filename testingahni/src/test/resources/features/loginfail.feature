Feature: Login Page

 Scenario: Login with invalid credentials
  
  Given user should be open link
  When user input invalid username and password
  And click button login
  Then cannot sign in