Feature: Free CRM create a new task feature

  Scenario: Create new task using HashMaps
    Given User in on Free CRM login Page
    When User enters credentials as username & password
      | kaustubhk | test@456 |
    Then User clicks the login button
    And User lands on Free CRM Home Page
    Then User navigates to New Task page
    And User enters task details as title & completion & deal & case & identifier
      | task1 | 10 | Deal1 | Case1 | I1 |
    Then User selects other task details as status,type & priority
    Then User saves the task
    Then User logs out of the Free CRM application
    Then User closed browser
