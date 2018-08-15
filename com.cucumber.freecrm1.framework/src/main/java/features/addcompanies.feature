Feature: Free CRM add companies feature

  Scenario Outline: Add companies with multiple credentials
    Given User is on Login Page
    When User enters "<username>" & "<password>"
    Then User clicks on Login button
    And User lands on Home Page
    Then User navigates to add New Company page
    Then User enters company details as "<company>" & "<industry>" & "<revenue>" & "<phone>" & "<address>"
    Then User saves company details
    Then User clicks on LogOut button
    Then User closes browser

    Examples: 
      | username  | password | company | industry | revenue | phone  | address |
      | kaustubhk | test@456 | C1      | I1       | 1000K   | 123456 | Pune    |
      | naveenk   | test@123 | C2      | I2       | 2000K   | 456789 | Mumbai  |
