@RunOnly
Feature: Register with ICICI banking functionality
  As a user of the ICICI bank
  I want to be able to register with my account


  Background: Successfully open the site
    Given I am on banking website

Scenario:Successfully click on login tab.
  Given mouseover on login tab.
  When click on personal link
  Then nagivate to Internet banking login page







