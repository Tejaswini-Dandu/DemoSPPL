Feature: Verify broken links on homepage
  @brokenlink
  Scenario: Open homepage and check brokenlinks
    Given Open homepage
    And Get all the links on the page
    Then Verify broken links