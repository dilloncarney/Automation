Feature: Trigger notify me error message
Hello Team
As a product manager
I want our users to not be able to submit an empty notify me forum

Scenario: Verify notify me invalid forum submission works
Given i open zappos "prod"
When i click mens shoes
Then i should get shoe
Given i am notify page
And i submit invalid notify info
Then i should trigger invalid notify message
Then i am closing browser