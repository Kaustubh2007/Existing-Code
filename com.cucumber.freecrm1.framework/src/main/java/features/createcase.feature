Feature: Free CRM create case feature

  Scenario: Create a new case using maps
    Given User is already on Free CRM Login Page
    When User enters username & password
      | username  | password |
      | kaustubhk | test@456 |
    Then User logs into the application
    And User lands on Free CRM login page
    Then User navigates to create New Case page
    And User enters case details as title & identifier & contact
      | title | identifier | contact |
      | Case1 | I1         |  123456 |
    Then User logs out of the CRM application
    Then User quites the browser
