Feature: To validate the login functionality of argos online application

  Scenario: To validate the login functionality of argos with invalid user credentials
    Given user should able to launch argos homepage
    When user have to click the cross button
    When user have to click the close button
    When user have to click the account button
    When user has to enter username "Poorani" and password "123456"
    And user have to click the login button
    Then user navigate to invalid login page
    
