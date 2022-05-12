Feature: Registration/Signup and Login flow

  @V_UI
  Scenario: Verify user registration
    Given User is on vita mojo demo site
    And Click on Create Account Tab
    When user enter name, email address, phone and password
    And user clicks on Create Account button
    Then user should be created

  @V_UI
  Scenario: Verify user is able to login
    Given User is on vita mojo demo site
    And Click on Login Tab
    When user enter email address and password
    And user clicks on Login button
    Then user should be redirected to Dashboard