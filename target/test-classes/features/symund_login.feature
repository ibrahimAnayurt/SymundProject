Feature: As a user, I should be able to login.

  Background: User is on the login page
    Given user is on the login page of Symund app

    @SYMU10-493
  Scenario: User can login with valid credentials (clicking on the "Login button")
    When User enters valid user name
    And User enters valid password
    And User click to the LOG IN button
    Then user can logged in and see the dashboard

  @SYMU10-494
  Scenario: User can login with valid credentials  (Hitting the "Enter" key from the keyboard as the last step
    When User enters valid user name
    And User enters valid password
    And User presses the  ENTER from keyboard
    Then user can logged in and see the dashboard

  @SYMU10-495
  Scenario Outline: User can not login with any invalid credentials
    When User enters invalid "<user name>" or invalid "<password>"
    And User click to the LOG IN button
    Then user can not logged in and "Wrong username or password." displayed
    Examples: Invalid user names and passwords
      | user name    | password     |
      | username     | password     |
      | Employee123  | Employee123  |
      | Employee150  | Employee150  |
      | Employee123  | Employee150  |
      | employee150  | employee123  |
      | Employe150   | Employe123   |
      | E            | Employee123  |
      | Employee150  | E            |
      | Employee1500 | Employee123  |
      | Employee150  | Employee12   |
      | Employee 150 | Employee123  |
      | Employee150  | Employee 123 |
      | *            | *            |


  @SYMU10-496
  Scenario Outline: User can not login without any credentials
    When User enters invalid "<user name>" or invalid "<password>"
    And User click to the LOG IN button
    Then "<user name>" can not logged in and displayed "Please fill out this field."
    Examples: Without any username or password
      | user name   | password    |
      |             |             |
      | Employee150 |             |
      |             | Employee123 |


  @SYMU10-497
  Scenario: User can see the password in a form of dots by default
    When User enters valid password
    Then User should see the password in a form of dots by default

  @SYMU10-498
  Scenario: User can see the password explicitly if needed
    When User enters valid password
    And User click to the eye sign button
    Then User can see the password explicitly

  @SYMU10-499
  Scenario: User can see the "Forgot password?" link on the login page and
  can see the "Reset Password" button on the next page after clicking on forget password link
    When User can see the forgot password button
    And User click to the forgot password button
    Then User should see the reset password button

  @SYMU10-500
  Scenario: User can see valid placeholders on Username and Password fields
    When user can see the valid placeholder on "Username or email" field
    And user should see the valid placeholder on "Password" field