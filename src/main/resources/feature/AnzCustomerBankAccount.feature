#Author: Bijoy Baral
#This feature file is for demonstration point of view and it's functionality is not implemented.
Feature: As a customer after authenticating to my Banking banking account(s), I will be presented to list of
  my accounts in a table

  @notAutomated
  Scenario: As a Banking customer when I try to view my account(s). I can see no account(s) are currently associated to my account
    Given I authenticate in Banking banking application with my user name 'banking-test-user-auto1' and password '****'
    When I view my account list
    Then I can see no account(s) are associated in my account

  @notAutomated
  Scenario: As a Banking customer when I try to view my account(s). I can see no account(s) are currently associated to my account
    Given I authenticate in Banking banking application with my user name 'banking-test-user-auto2' and password '****'
    When I view my account list
    Then I can see list of account(s) are associated in my account with basic attributes
      | accountNumber | accountName  | accountType | balanceDate | currency | openingAvailableBalance |
      |     123456789 | SGSavings726 | Savings     | 08/01/2011  | SGD      |               14,234.98 |
      |     123442789 | AUSavings726 | Savings     | 09/02/2012  | AUD      |               24,234.98 |
      |     123457789 | SGSavings726 | Savings     | 10/03/2013  | SGD      |               34,234.98 |
      |     123498689 | SGSavings726 | Savings     | 18/04/2014  | SGD      |               44,234.98 |
      |     123456756 | USSavings726 | Savings     | 28/05/2015  | USD      |               54,234.98 |
      |     123456721 | SGSavings726 | Savings     | 28/06/2016  | SGD      |               64,234.98 |
      |     123456732 | SGSavings726 | Savings     | 08/07/2017  | SGD      |               74,234.98 |
      |     123456737 | SGSavings726 | Savings     | 08/08/2018  | SGD      |               84,234.98 |
      |     123456734 | SGSavings726 | Savings     | 08/09/2007  | SGD      |               94,234.98 |
      |     123456721 | AUSavings726 | Savings     | 08/10/2018  | AUD      |               86,234.98 |
      |     123456743 | SGSavings726 | Savings     | 07/11/2018  | SGD      |               86,234.98 |
      |     123456720 | SGSavings726 | Savings     | 08/11/2018  | SGD      |               80,234.98 |
      |     123355781 | USSavings726 | Savings     | 08/11/2018  | USD      |               81,234.98 |
      |     123344789 | SGSavings726 | Savings     | 11/11/2018  | SGD      |               82,234.98 |
      |     123456439 | SGSavings726 | Savings     | 10/11/2018  | SGD      |               84,234.98 |
