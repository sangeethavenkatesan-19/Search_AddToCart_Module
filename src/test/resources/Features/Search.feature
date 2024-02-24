#Author: Sangeetha Venkatesan
Feature: Search products on Firstcry.com
  User wants test search bar with multiple products on firstcry.com

  Scenario Outline: Verification of search feature button with few products
    Given Open the Chrome and launch Firstcry application
    And Maximize the Chrome browser window
    When Enter the Product that has to be searched "<product_name>"
    Then Click the Search button
    And Verify the title "<page_title>"

    Examples: 
      | product_name    | page_title                                                                               |
      | Baby Bath Tub   | Baby Bath Tub - Buy Bath Tub for Babies Online at Best Price                             |
      | Die Mild Powder | Buy Die Mild Powder at Best Price, Online Baby and Kids Shopping Store - FirstCry.com    |
      | Footwear        | Best Footwear on FirstCry.com (Feb 2024) - Shop Online in India                          |
      |                 | Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com |
