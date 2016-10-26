Feature: verify wiring of testing tools
  As a developer
  I want to test my code
  So that I can freely think of following

Scenario: Say Hello to world
  Given a simple setup
  When I maven verify
  Then cucmber says "Hello World"

