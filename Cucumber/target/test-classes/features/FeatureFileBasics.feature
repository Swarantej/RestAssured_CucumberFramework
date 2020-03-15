Feature: Learning the Basics of Featurefile

Scenario: Learning to Write the steps
Given I login to the page with id "Swaran" and pwd "test123"
When I'm navigated to the landing page
Then I validate the my account details
And I see the balance

Scenario: Learning to Write the steps test case 2
Given I login to the page with id "Swarantej" and pwd "tes"
When I'm navigated to the landing page
Then I validate the my account details
And I see the balance