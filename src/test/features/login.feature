#Author: chetan shavanti
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some steps
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

@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @Testcase1
  Scenario: verifies user id not found error message
    Given user is on Snaptrude login page
    When user enters user name as "WrongTestdata@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    Then user verifies user id not found error message

 @Testcase2
  Scenario: verifies user id not found error message
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@1234"
    And user clicks on Sign in button
    Then user verifies incorrect username or password error message
   
   
     @Testcase3
  Scenario: verifies user id and password are correct.
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    Then user verifies user id and password are correct
    
        @Testcase4
  Scenario: verifies user id and password are correct.
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    And user clicks on Test Project 
    Then user verifies test project is clicked
    
    
            @Testcase5
  Scenario: Draw Rectangle.
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    And user clicks on Test Project
    When user draw a rectangle
    Then user verifies rectangle is visible
    
            @Testcase6
  Scenario: Draw circle.
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    And user clicks on Test Project
    When user draw a circle
    Then user verifies circle is visible
    
    
                @Testcase7
  Scenario: Draw Hexagon.
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    And user clicks on Test Project
    When user draw a Hexagon
    Then user verifies Hexagon is visible
    
    
                   @Testcase8
  Scenario: Draw Walls.
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    And user clicks on Test Project
    When user draw a Walls
    Then user verifies Walls are visible
    
    
 
                       @Testcase9
  Scenario: Draw Floor.
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    And user clicks on Test Project
    When user draw a Floor
    Then user verifies Floor is visible
    
    
    
    
     
                       @Testcase10
  Scenario: Draw Slab.
    Given user is on Snaptrude login page
    When user enters user name as "chetan.g.shavanti@gmail.com"
    And user enters password as "Test@123"
    And user clicks on Sign in button
    And user clicks on Test Project
    When user draw a Slab
    Then user verifies Slab is visible
    
    
    
    
    
    
    
    
    
    