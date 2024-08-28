Feature: login with personal login option
  As a user of the ICIC bank
  I want to login to internet banking with userId and password.
  so that i can access my account-related features and manage my banking.


  Background: Successfully open the internet banking page
    Given I am on internet banking personal login page

  Scenario Outline: Successfully login to Internet Banking page
   Given Click on login with userId and Password tab
    And Enter valid Username "<UserId>"
    And Enter valid Password "<Password>"
    And Select valid StartIn_options "<StartInOps>"
    And Click on Remember_User_Id checkbox
    When Click on Login button
    Then Successfully navigated to internet banking.
    Examples:
      |UserId   |Password  |StartInOps|
      |567359917|Jazzu@2709|Bank Account|

@NegativeTest
  Scenario Outline: Negative Scenario of login to Internet Banking page
    Given Click on login with userId and Password tab
    And Enter Username "<UserId>"
    And Enter Password "<Password>"
    And Select StartIn_options "<StartInOps>"
    And Click on Remember_User_Id checkbox
    When Click on Login button
    Then Received error msg as "<ErrorMsg>"
    Examples:
      |UserId   |Password  |StartInOps|ErrorMsg|
      |567359917||Bank Account|Please enter your Password|
     |         |Jazzu@2709|Bank Account|Please enter your User ID|
     |5673599|Jazzu@2709|Bank Account|The login credentials which you have entered are invalid. Please provide valid credentials to prevent your login from being disabled.|


