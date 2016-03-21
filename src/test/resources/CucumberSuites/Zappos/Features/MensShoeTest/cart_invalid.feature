Feature: Trigger cart error message
Hello Team
As a product manager
I want our users to not be able to add to cart without making a selection

Scenario: Empty cart, add to cart without making a selection
Given i open zappos "prod"
When i click mens shoes
Then i should get shoe
When i click add to cart
Then i see cart error
Then i am closing browser