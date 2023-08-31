@Smoke
Feature: Retail Account Page

  Background: 
    Given User is on retail website homepage
    When User click on the login link
    And User enter email 'nchurrican@gmail.com' and password 'Nchurrican911$'
    And User click on login button
    Then Verify user is logged in

  @updatePI
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Storme' and Phone 'phoneNumber'
    And User click on Update button
    Then user profile information should be updated

  @addPaymentMethod
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      | cardNumber | GulMarJan  |              10 |           2024 |          235 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

  @editPaymentMethod
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber | nameOnCard  | expirationMonth | expirationYear | securityCode |
      | cardNumber | HurricanOne |               6 |           2027 |          666 |
    And user click on Update Your Card button
    Then message should be displayed 'Payment Method updated Successfully'

@removePaymentmethod
Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed
    
  @addAddress
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click Add Your Address button
    Then a message should be displayed as 'Address Added Successfully'

  @AddressEdit
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill edits address form with below information
      | country     | fullName | phoneNumber | streetAddress | apt | city   | state | zipCode |
      | Afghanistan | Ghani    |  5226584777 | 123 Main RD   | 101 | Durham | VA    |   20147 |
    And User click update Your Address button
    Then update message should be displayed 'Address Updated Successfully'

  @removeAddress
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
