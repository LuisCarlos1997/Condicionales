Feature: I as a user want to choose if it is a dog or a cat on thelab page

  Scenario: dog or cat conditional
    Given  Luis open page the lab cat or dog
    When by clicking the generate image button, the animal that appears is chosen
    Then you get a successful response
