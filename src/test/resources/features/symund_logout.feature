Feature: As a user, I should be able to log out.

  Background: As a user, I should be able to log out.
    Given User is logged in and is on the dashboard page

  Scenario: User can log out and ends up in login page
    When User click to the account name dropdown
    And User see and click the Log out button
    Then User logged out and see the login page

  Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    When User click to back button from browser
    Then User can not go back to the Dashboard page(home page)

