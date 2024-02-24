#Author: Sangeetha Venkatesan
Feature: Search for a product apply filters and add it to cart in Firstcry.com
  User wants test add to cart functionality with filters(advance search) on firstcry.com

  Scenario: Verification of add to cart feature with advance search
    Given Open the ChromeBrowser and launch application
    And Maximize the browser
    When The pages loades click any one category from homepage
    Then Move to the redirected page and scroll down to view products
    When apply filters according to your requirements
    And select a product and add to cart
