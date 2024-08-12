@SignUpDemoBlaze @ApiFlows
Feature: Create account
  As user of DemoBlaze page
  I want to use the services Post method
  To create one account

  @SignUpSuccessful
  Scenario: SignUp Successful
    * header Content-Type = 'application/json'
    * header Accept = '*/*'
    Given url 'https://api.demoblaze.com/signup'
    And def user = read('classpath:../data/demo/ApiSignUp.json')
    And request user
    * print user
    When method POST
    Then status 200


  @SignUpFailed
  Scenario: SignUp Failed
    * header Content-Type = 'application/json'
    * header Accept = '*/*'
    Given url 'https://api.demoblaze.com/signup'
    And def user = read('classpath:../data/demo/ApiSignUp.json')
    * print user
    When method POST
    * print response
    Then status 411
