Feature: Testing the Shopping cart of the e-commerce website(Test Case no4)

  Scenario: Testing the Shopping cart of the e-commerce website
    Given User Sign in Amazon website"9960060622""Mar$1603"
    Given Is the correct price getting displayed in the shopping cart for the selected products"Books""Wisdom From The Ramayana: On Life and Relationships"
    Then Can a user increase or decrease the quantity of a product from shopping cart"8""1"
    When Is there an option to apply coupn codes
    Then Can a user remove the product from the shopping cart