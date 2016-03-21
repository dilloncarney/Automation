Feature: Find shoe
Hello Team
As a product manager
I want our users to be able to pick a shoe
By going through Mens/Womens -> Style -> Brand 


Scenario: Pick a shoe
Given i open zappos "prod"
When i click mens shoes
Then i should get shoe
Then i am closing browser