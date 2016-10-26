Bank account kata
=================

Think of your personal bank account experience
When in doubt, go for the simplest solution

Requirements
------------

Deposit and Withdrawal  
Transfer  
Account statement (date, amount, balance)  
Statement printing  
Statement filters (just deposits, withdrawal, date)

The Rules
---------

1. One level of indentation per method
2. Don’t use the ELSE keyword
3. Wrap all primitives and Strings
4. First class collections
5. One dot per line
6. Don’t abbreviate
7. Keep all entities small (50 lines)
8. No classes with more than two instance variables
9. No getters/setters/properties

#### For more information:

-  [Object Calisthenics pdf](http://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf)
-  Object Calisthenics (full book), Jeff Bay in: The ThoughtWorks Anthology.
Pragmatic Bookshelf 2008
-  Original idea for the kata: How Object-Oriented Are You Feeling Today? - Krzysztof Jelski (Session on the Software Craftsmanship UK 2011 conference)


### My (*unfinished*) features

Started from defining a simple feature:

Feature: Withdraw from account
  As a client of the bank
  I want to withdraw money from my account
  In order to have cash

  Scenario: An existing client withdraws from his account
      Given an existing client named "pierre-jean" with 100.0 EUR in his account
      When he withdraws 10.0 EUR from his account
      Then the new balance is 90.0 EUR 

The files to look at:

[filename](https://github.com/coulas/path/to/filename)  
