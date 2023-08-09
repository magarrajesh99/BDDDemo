Feature: Search the domain name and validate whether domain is available or not(Test case no1)

  Scenario: validate whether search domain is available or not
  #Given Launch browser of your choice 
  #Given Open website URL "godaddy.com"
  #When Maximize browser window
  #When set timeout using implicit wait command of selenium webdriver
  When click on the first menu link which is Domains it will open up sub menu 
  When Click on the Domain Name Search link from sub menu
  When Get value of title of "GoDaddy Domain Search - Buy and Register Available Domain Names" page and print it
  Then Verify that the search box is present on the page and its enabled  
  Then Enter some test value in the search box like "mydomain" and click on Add to Cart button
  Then Verify that the price "₹ 5,249.00" of the domain is also displayed along with domain name "mydomain.com"