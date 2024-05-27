Feature: LoginForm
  Scenario: User can log in correctly
    Given The user is at "https://the-internet.herokuapp.com/login"
    When The user introduces "tomsmith" as username
    And The user introduces "SuperSecretPassword!" as password
    And The user pushes the "login" button
    Then The message "Welcome to the Secure Area. When you are done click logout below." is shown