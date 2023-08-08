Feature: Search the domain name and validate whether domain is available or not(Test case no1)

  Scenario: validate whether search domain is available or not
  #Given Launch browser of your choice 
  #Given Open website URL "godaddy.com"
  #When Maximize browser window
  #When set timeout using implicit wait command of selenium webdriver
  When click on the first menu link which is 'Domains'It will open up sub menu 
  When Click on the "Domain Name Search" link from sub menu
  When Get value of title of "Domain Name Search" page and print it
  Then We will match fetch value with expected value
  Then Verify that the search box is present on the page and its enabled
  Then Verify that 'Buy It' button is available along with search box
  Then Enter some test value in the search box like "My Domain" and click on "Buy It" button
  Then If the domain is available then verify tha the "Add to Cart" button is present alongside domain name
  Then Verify that the price of the domain is also displayed along with domain name