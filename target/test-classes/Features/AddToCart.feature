#Author: Sangeetha Venkatesan
Feature: Search for a product and add it to cart in Firstcry.com
  User wants test add to cart functionality with multiple products on firstcry.com

  Scenario Outline: Verification of add to cart feature with few products
    Given Open the Firstcry application in chrome Browser
    And Browser should be maximized
    When Search for a product "<product_name>"
    Then Click Search Button
    And Click a specific product to view
    Then Click AddToCart for a product
    And Verify the title of the product page "<page_title>"

    Examples: 
      | product_name  | page_title                                                                                                          |
      | Baby Bath Tub | Babyhug Foldable Bathtub with Printed Cushion - Blue Online in India, Buy at Best Price from FirstCry.com - 9714851 |
      | Tricycles     | Baby Gear Online Shopping - Walkers, Strollers, Carriers, Car Seats & more                                          |
