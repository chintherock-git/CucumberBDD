#Author: chinzaa
#Keywords Summary : This is a sample BDD project based on Cucumber and Java
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
@SanityFeature
Feature: feature to test login functionality

   @sanity
  Scenario: Check login is successful with valid credentials
    Given User is on Home Page
    When user enters valid username and password in username and password field
    And user clicks on the login button
    Then user is navigated to home page
    And User views the content of homepage
