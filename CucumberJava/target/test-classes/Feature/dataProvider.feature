#Author: chinmayee baitharu
#Keywords Summary : this feature file tests the login to SauceLabs demo 
#Feature: List of scenarios.

#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: username and password for login
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@FunctionalFeature
Feature: Verifies Login to Sauce_demo
  I want to use this template for my feature file

 @Functional
  Scenario Outline: Login to saucedemo admin page
    Given User opens the web page URL
   	Then User views login form with username and password
    When User enters "<username>" and "<password>" in username and password field  
    Then verifies the cart icon in homepage
 
    Examples: 
      | username  | password |  
      | standard_user | secret_sauce | 
      | performance_glitch_user | secret_sauce | 
