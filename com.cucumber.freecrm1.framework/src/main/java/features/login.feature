Feature: Free CRM login feature

  @SmokeTest
  Scenario: Login with kaustubh's credentials
    Given User is already on Free CRM login Page
    When User enters "kaustubhk" and "test@456"
    And User clicks on login button
    Then User is on Home Page
    Then User logs out of the application
    Then User closes the browser

  @RegressionTest @SmokeTest
  Scenario: Login with invalid credentials
    Given User is already on Free CRM login Page
    When User enters "kaustubh" and "test@456"
    And User clicks on login button
    Then User is on Home Page
    Then User logs out of the application
    Then User closes the browser

  @PerformanceTest 
  Scenario: Login with naveen's credentials
    Given User is already on Free CRM login Page
    When User enters "naveenk" and "test@123"
    And User clicks on login button
    Then User is on Home Page
    Then User logs out of the application
    Then User closes the browser
