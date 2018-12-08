Feature: Search articles in site

  Scenario: user can search any article in our site
    Given an open browser with room5.trivago.com
    When click to search button
    And wait visible search layout and search input
    And send to search input field USA and press Enter
    Then wait number 2 articles in search results