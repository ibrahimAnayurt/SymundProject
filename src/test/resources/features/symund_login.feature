Feature: As a user, I should be able to login.

  Background: User is on the login page
    Given user is on the login page of Symund app

  Scenario: User can login with valid credentials (clicking on the "Login button")
    When User enters valid user name
    And User enters valid password
    And User click to the LOG IN button
    Then user can logged in and see the dashboard

  Scenario: User can login with valid credentials  (Hitting the "Enter" key from the keyboard as the last step
    When User enters valid user name
    And User enters valid password
    And User presses the  ENTER from keyboard
    Then user can logged in and see the dashboard

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