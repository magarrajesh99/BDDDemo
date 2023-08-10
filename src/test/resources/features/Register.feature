Feature: Testing registration and login of the online shopping website(Test case no2)

  Scenario: Verify testing registration and login of the online shopping website
    Given Can a guest purchage product as a guest user"Books""Wisdom From The Ramayana: On Life and Relationships"
    When Can a guest able to register on the website
      | Named        | Mobile Number | email id.com            | password |
      | Rajesh Magar |    9960060622 | magarrajesh99@gmail.com | Mar$1603 |
    Then Once registered can a user able to log in successfully"9960060622""Mar$1603"
    Then Can a registered user able to view all the products listed on the website
    Then Is the registered user able to view and modify its user account information
      | Named        | Mobile Number | 
      | Rajesh Magar | +919960060622 | 
    Then Are the user sessions being manitained for the intended time period
    Then Is the users session timing out and expiring after a defined time
    Then Is the registered user not able to access the user account after logout"Mar$1603"