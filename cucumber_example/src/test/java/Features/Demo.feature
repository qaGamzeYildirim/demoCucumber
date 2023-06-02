@Register
Feature: Demo Feature

  Scenario Outline: Register Login And Add To Cart Scenarios
    Given Homepage loads
    When The user clicks by id signin2
    And Write by id on the sign in modal sign-username <username>
    And Write by id on the sign in modal sign-password <password>
    And Click by xpath on sign in modal //button[@class='btn btn-primary' and text()='Sign up']
    Then The user sees successful popup Sign up successful.
    When The user clicks by id login2
    And Write by id on the login modal loginusername <username>
    And Write by id on the login modal loginpassword <password>
    And Click by xpath on login modal //button[@class='btn btn-primary' and text()='Log in']
    Then The user compares object with text by id nameofuser Welcome <username>
    When The user clicks by xpath //a[text()='HTC One M9']
    And The user compares object with three text by xpath //div[@id='tbodyid']/h2 HTC One M9
    And The user compares to contains object with text by xpath //div[@id='tbodyid']/h3 $700
    And The user compares object with text by only xpath for product description //div[@id='more-information']/p
    And The user clicks by xpath //a[@class='btn btn-success btn-lg' and text()='Add to cart']
    And The user clicks by id cartur
    And The user sees successful popup <Product added>
    And The user compares object with text by xpath //div[@id='page-wrapper']/div/div[1]/h2 Products
    And The user compares object with three text by xpath (//tr[@class='success']/td)[2] HTC One M9
    And The user compares object with text by xpath (//tr[@class='success']/td)[3] 700
    And The user clicks by cssSelector .col-lg-1 button
    And The user compares object with text by id orderModalLabel Place order
    And The user writes by id name <username>
    And The user writes by id country <country>
    And The user writes by id city <city>
    And The user writes by id card <creditCard>
    And The user writes by id month <month>
    And The user writes by id year <year>
    And The user clicks by cssSelector #orderModal .modal-dialog .modal-footer .btn-primary
    And The user compares object with text by only cssSelector for purchase .sweet-alert h2
    And The user clicks by cssSelector .sa-confirm-button-container button
    Examples:
      | username       |  | password  |  | country |  | city     |  | creditCard       |  | month |  | year |
      | test_bilyoner  |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner1 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner2 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner3 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner4 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner5 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner6 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner7 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner8 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyoner9 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |
#      | test_bilyone99 |  | Abcd.1234 |  | Turkey  |  | Istanbul |  | 1111111111111111 |  | 01    |  | 2028 |