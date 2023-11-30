Feature: Test the CRUD methods in Products Microservice

  Scenario: Adding a product with specific data
    Given I set POST product api endpoint
    When I set request Header and send the POST HTTP request
    Then I receive valid response

  Scenario: Retrieving product details by ID
    Given I set GET product api endpoint
    When I send a GET HTTP request for product with ID 9996
    Then I receive a valid response with product details
