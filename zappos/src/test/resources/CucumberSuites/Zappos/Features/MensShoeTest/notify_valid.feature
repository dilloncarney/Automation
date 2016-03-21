Feature: Complete notify me forum
Hello Team
As a product manager
I want our users to be able to submit a valid notify forum

Scenario: Verify notify me valid forum submission works
Given i open zappos "prod"
When i click mens shoes
Then i should get shoe
Given i am notify page
When i submit valid notify info
Then i should trigger valid notify message
Then i am closing browser