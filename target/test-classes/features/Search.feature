Feature: Testing search feature of the online shopping website(Test case no3)

  Scenario: Testing search feature of the online shopping website
    Given Is the website having multiple filters to search products like price range,category,brands etc "Books"
    When Are relevent products displaying after applying single or multiple search filters
    Then Is there an option to display a fixed number of products on the search page
    Then Is there any sort option available on the search page and is that working properly "Price: Low to High" "Price: High to Low"