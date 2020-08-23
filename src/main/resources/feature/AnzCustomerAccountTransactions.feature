#Author: Bijoy Baral
#This feature file is for demonstration point of view and it's functionality is not implemented.
Feature: As a customer after clicking on my Banking banking account number, I will be presented to list of transaction(s)
  in my account(s) in a table

  @notAutomated
  Scenario: As a Banking customer when I try to view list of transaction by clicking on my account number. I can see no transaction on my selected account are currently associated with
    Given I have presented list of account(s) associated with my user id 'banking-test-user-auto3'
    When I click on a account number '236789231'
    Then I can see no transaction(s) are associated with the selected account

  @notAutomated
  Scenario: As a Banking customer when I try to view list of transaction by clicking on my account number. I can see list of transaction(s) on my selected account
    Given I have presented list of account(s) associated with my user id 'banking-test-user-auto4'
    When I click on a account number '238943276'
    Then I can see list of transaction(s) are associated with my selected account with basic attributes
      | accountNumber | accountName  | valueDate  | currency | debitAmount | creditAmount | debitOrCredit | transactionNarrative |
      |     123456789 | SGSavings726 | 08/01/2011 | SGD      |   10,234.98 |    14,234.98 | credit        | Savings need         |
      |     123442789 | AUSavings726 | 08/01/2011 | AUD      |   11,234.98 |    24,234.98 | debit         |                      |
      |     123457789 | SGSavings726 | 10/03/2013 | SGD      |   12,234.98 |    34,234.98 | credit        |                      |
      |     123498689 | SGSavings726 | 18/04/2014 | SGD      |   13,234.98 |    44,234.98 | debit         |                      |
      |     123456756 | USSavings726 | 28/05/2015 | USD      |   14,234.98 |    54,234.98 | debit         |                      |
      |     123456721 | SGSavings726 | 28/06/2016 | SGD      |   15,234.98 |    64,234.98 | credit        |                      |
      |     123456732 | SGSavings726 | 08/07/2017 | SGD      |   16,234.98 |    74,234.98 | debit         |                      |
      |     123456737 | SGSavings726 | 08/08/2018 | SGD      |   17,234.98 |    84,234.98 | debit         |                      |
      |     123456734 | SGSavings726 | 08/09/2007 | SGD      |   18,234.98 |    94,234.98 | debit         |                      |
      |     123456721 | AUSavings726 | 08/10/2018 | AUD      |   19,234.98 |    86,234.98 | credit        |                      |
      |     123456743 | SGSavings726 | 07/11/2018 | SGD      |   10,234.98 |    86,234.98 | debit         |                      |
      |     123456720 | SGSavings726 | 08/11/2018 | SGD      |   13,234.98 |    80,234.98 | debit         | Shopping need        |
      |     123355781 | USSavings726 | 08/11/2018 | USD      |   14,234.98 |    81,234.98 | debit         |                      |
      |     123344789 | SGSavings726 | 11/11/2018 | SGD      |   14,234.98 |    82,234.98 | debit         |                      |
      |     123456439 | SGSavings726 | 10/11/2018 | SGD      |   14,234.98 |    84,234.98 | credit        |                      |
