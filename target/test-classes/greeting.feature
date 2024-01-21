Feature: Greeting API

  Scenario: Greeting with default name 
    Given the application is up and running 
    When a GET request is made to the greeting endpoint 
    Then the response should contain the default greeting message

  Scenario: Greeting with a custom name 
    Given the application is up and running 
    When a GET request is made to the greeting endpoint with name "Spring Community" a query parameter 
    Then the response should contain the tailored greeting message for "Spring Community"
