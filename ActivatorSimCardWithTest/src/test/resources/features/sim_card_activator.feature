Feature: Sim Card Activator
  Scenario: Sim card activate is successfully
    Given Proper sim card
    When A request is sent to activate the Sim card
    Then Sim card is activated

  Scenario: Sim card activate not successful
    Given Improper Sim card
    When A request is sent to activate the Sim card
    Then Sim card is not activated
