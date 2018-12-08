Feature: subscription to Newsletter

  Scenario: user can subscription to our newsletters

    Given an open browser with room5.trivago.com
    When scroll to footer and send email address your-email@domen.de is footer input field
    And  click "Inspire Me" button
    Then  show successful message in footer