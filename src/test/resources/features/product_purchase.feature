@RetoDevsu
Feature:  Challenge Web Devsu, to buy technologic devices

  @id:1 @ProductPurchase
  Scenario Outline: Purchase two devices.
    Do successful purchase of two devices and fill required data
    Given that Jhonatan David goes to demoblaze page to select the "<firstProduct>" and "<secondProduct>"
    When he wants to make a purchase enter his personal data
      | name   | country   | city   | card   | month   | year   |
      | <name> | <country> | <city> | <card> | <month> | <year> |
    Then he can see Successesful purchase message
    Examples:
      | @externaldata@demo/WebDataToPurchase.xlsx..purchase |

  

