Feature: In order to remember the things I want to do, as a ToDo MVC user, I want to manage my todo list

  #1
  Scenario Outline: Verify the static content on ToDos homepage
    Given user is on the To Do List home page
    Then user should view <headerText> header text in To Do page
    And user should view <placeHolderText> place holder text in To Do field
    And user should view footer below the To Do form

    Examples:
      | headerText  | placeHolderText |
      |todos| What needs to be done?  |
  #2
  Scenario Outline: verify if entered item is displayed in to do list
    Given user is on the To Do List home page
    When user enters <item> in To Do field
    Then user should view untoggled items in the list
    And the item count should be updated in the footer

    Examples:
      | item  |
      |pickup groceries|

  #3
  @ToDoListActions
  Scenario Outline: verify if numeric and special characters entered are stored in list
    Given user is on the To Do List home page
    When user enters <item> in To Do field
    Then user should view untoggled items in the list
    And the item count should be updated in the footer

    Examples:
      | item  |
      |####12*^+23424|

  #4
  Scenario: verify if un-toggled item is displayed in All and Active tabs
    Given user is on the To Do List home page
    When user enters multiple items to To Do List
    |pickup groceries|
    |buy fruits|
    |watch football|
    Then user should view untoggled items in the list
    And the item count should be updated in the footer
    When user clicks on Active tab in footer
    Then user should view untoggled items in the list

  #5
  Scenario: verify if un-toggled item is displayed in Completed tabs
    Given user is on the To Do List home page
    When user enters multiple items to To Do List
      |pickup groceries|
      |buy fruits|
      |watch football|
    Then user should view untoggled items in the list
    And the item count should be updated in the footer
    When user clicks on Completed tab in footer
    Then user should not view any untoggled items in the list

  #6
  Scenario: verify if toggled item is displayed in Active tab
    Given user is on the To Do List home page
    When user enters multiple items to To Do List
      |pickup groceries|
      |buy fruits|
      |watch football|
    Then user should view untoggled items in the list
    When user toggles buy fruits item in To Do list
    Then the item count should be updated in the footer
    When user clicks on Active tab in footer
    Then user should view untoggled items in the list

  #7
  Scenario: verify if toggled item is displayed in Completed tab
    Given user is on the To Do List home page
    When user enters multiple items to To Do List
      |pickup groceries|
      |buy fruits|
      |watch football|
    Then user should view untoggled items in the list
    When user toggles buy fruits item in To Do list
    Then the item count should be updated in the footer
    When user clicks on Completed tab in footer
    Then user should view toggled items in the list

  #8
  Scenario: Verify if all items are marked as completed when clicked on toggle all button
    Given user is on the To Do List home page
    When user enters multiple items to To Do List
      |pickup groceries|
      |buy fruits|
      |watch football|
    Then user should view untoggled items in the list
    When user clicks on toggle all button
    Then user should view all items marked as completed

  #9
  Scenario: Verify if Clear completed button is displayed when an item is toggled
    Given user is on the To Do List home page
    When user enters multiple items to To Do List
      |pickup groceries|
      |buy fruits|
      |watch football|
    Then user should view untoggled items in the list
    When user toggles buy fruits item in To Do list
    Then user should view Clear completed button in To Do list

  #10
  Scenario: Verify if toggled items are removed from list when clicked on clear completed button
    Given user is on the To Do List home page
    When user enters multiple items to To Do List
      |pickup groceries|
      |buy fruits|
      |watch football|
    Then user should view untoggled items in the list
    When user toggles buy fruits item in To Do list
    Then user should view Clear completed button in To Do list
    When user clicks on Clear completed button
    Then user should not view any toggled items in the list

  #11
  Scenario: Verify if items are removed from list when clicked on cross button of item
    Given user is on the To Do List home page
    When user enters multiple items to To Do List
      |pickup groceries|
      |buy fruits|
      |watch football|
    Then user should view untoggled items in the list
    When user clicks on cross button of item buy fruits
    Then user should not view buy fruits item in the list