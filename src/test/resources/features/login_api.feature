@LoginDemoBlaze @ApiFlows
Feature: Login
  As user of DemoBlaze page
  I want to use the services Post method
  To login and see my profile

  @LoginSuccessful
    Scenario: Login Successful
    * header Content-Type = 'application/json'
    * header Accept = '*/*'
    Given url 'https://api.demoblaze.com/login'
    And def user = read('classpath:../data/demo/ApiLoginSuccessful.json')
    And request user
    * print user
    When method POST
    Then status 200
    * print response
    And print response[0].Auth_token

  @LoginFailed
  Scenario: Login Failed
    * header Content-Type = 'application/json'
    * header Accept = '*/*'
    Given url 'https://api.demoblaze.com/login'
    And def user = read('classpath:../data/demo/ApiLoginFailed.json')
    And request user
    * print user
    When method POST
    * print response
    Then status 200
    And def userVal = read('classpath:../data/demo/ValidateLoginFailed.json')

