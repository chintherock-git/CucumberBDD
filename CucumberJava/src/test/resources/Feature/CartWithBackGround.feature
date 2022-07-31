#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@SmokeFeature
Feature: This feature verifies addto cart, remove, placing Order


  Background: User logs in and adds item to shopping cart
    Given user is in login page
    Then views login and password and login button
    Then enters username and Password and clicks on login button
    And user lands to Home page and views Empty cart
    And adds item to cart
    Then checks the count of the cart

  @smoke
  Scenario: checks remove item from cart
    When user is in landing page
    And clicks the cart and removes item from the cart and makes its empty

  @smoke
  Scenario: verifies submitting shopping request
    When user is in home page navigates to cart page
    Then clicks checkout
    Then enters details in your Information page and clicks continue
    And navigates to Checkout Overview page and clicks finish
    And completes the checkout
