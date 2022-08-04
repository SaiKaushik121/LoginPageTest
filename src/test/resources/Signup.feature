Feature: feature to test login functionality

  Background: Homepage
    Given user is on home page "https://accessapp.netlify.app/"
    When Clicks on signup

  @one
  Scenario: User clicks on signup
    Then register page opened

  @two
  Scenario Outline: user enters data
    Given user fullname <fullname>
    And user email <emailid>
    And user username <username>
    And user password <password>
    And user number <contactnumbers>
    Then clicks on signup register

    Examples: 
      | fullname     | emailid                     | username        | password        | contactnumbers |
      | kaushikpoppp | kkkkkkkkau789shik@gmail.com | Kaukkkkkshik678 | Kaushkkkik@7890 |     7985856256 |

  @three
  Scenario: Checking for all blank fields
    Given user clicks on sign up without any detail

  @four
  Scenario Outline: testing fullname inputs with numbers and special characters
    Given user enters fullname with <numorchar>
    Then Expected error msg "* Enter Only Alphabets"

    Examples: 
      | numorchar  |
      | kaushik789 |
      | kaushik@@@ |

  @five
  Scenario Outline: testing fullname inputs with numbers and special characters
    Given user enters email without@gmail <email>
    Then Expected error emailmsg "* Enter a valid email"

    Examples: 
      | email    |
      | kaushik  |
      | kaushik@ |

  @six
  Scenario Outline: testing username with all combinations
    Given user enters username <username> and clicks on sign up

    Examples: 
      | username        |
      | Kau             |
      | Kaushik@        |
      | !@#$%^&*        |
      |     11111111111 |
      | 123456789111213 |

  @seven
  Scenario Outline: testing password with all cobinations
    Given user enters <password> and clicks on sign up

    Examples: 
      | password         |
      | fjfjebfebfebfebf |
      | kau              |
      | Kaushikk         |
      |        123456789 |
      | Kaushik@789      |
