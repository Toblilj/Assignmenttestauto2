Feature: registration


  #1
  Scenario: Create user with correct information
    Given user is on the correct website
    When user enters valid date of birth
    When user enters valid  correct firstname
    When user enters valid correct lastname
    When user enters valid email adress
    When user enters valid password
    When user clicks terms and conditions box
    When user clicks above required age box
    When user clicks code of ethics box
    Then  an account is created

    #2
  Scenario: Create user with no last name
    Given user is on the correct website
    When user enters valid date of birth
    When user enters valid  correct firstname
    When user enters valid email adress
    When user enters valid password
    When user clicks terms and conditions box
    When user clicks above required age box
    When user clicks code of ethics box
    When user click confirm and join button
    Then a last name is missing is shown

    #3
    Scenario:register with diffrent passwords
    Given user is on the correct website
      When user enters valid date of birth
      When user enters valid  correct firstname
      When user enters valid correct lastname
      When user enters valid email adress
      When user enters valid password
      When user enters diffrent password confirmation
      When user clicks terms and conditions box
      When user clicks above required age box
      When user clicks code of ethics box
      When user click confirm and join button
    Then a password does not match is shown

      #4
    Scenario: register without terms and conditions
    Given user is on the correct website
      When user enters valid date of birth
      When user enters valid  correct firstname
      When user enters valid correct lastname
      When user enters valid email adress
      When user enters valid password
      When user clicks above required age box
      When user clicks code of ethics box
      When user click confirm and join button
    Then a error message is shown