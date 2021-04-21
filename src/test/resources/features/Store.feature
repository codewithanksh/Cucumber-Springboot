Feature: Create,Update & Delete a store

  Scenario Outline: User adds a new store
    Given User verifies no store with id <StoreId> exists
    Then User provides following address details for store <StoreId>
      | zip   | locationName          | addressLine1           | addressLine2      | city       | bopisEnabled | phone      | countryCode | state | displayAddress     | hours                                                                                             |
      | 95035 | American Eagle Outlet | 454 Mall of Travancore | 454 Great Mall Dr | Pittsburgh | false        | 4085869520 | US          | CA    | MALL OF TRAVANCORE | 1:10:00:21:00,2:10:00:21:00,3:10:00:21:00,4:10:00:21:00,5:10:00:21:00,6:10:00:21:00,7:11:00:18:00 |
    And following are the geographical location details for store <StoreId>
      | timezone         | language | latitude         | longitude         |
      | America/New_York | en       | 37.4157284338244 | -121.897626681671 |
    And following are the shift details for store <StoreId>
      | Day       | from  | till  | isClosed |
      | Sunday    | 10:00 | 21:00 | false    |
      | Monday    | 10:00 | 21:00 | false    |
      | Tuesday   | 10:00 | 21:00 | false    |
      | Wednesday | 10:00 | 21:00 | false    |
      | Thursday  | 10:00 | 21:00 | false    |
      | Friday    | 10:00 | 21:00 | false    |
      | Saturday  | 10:00 | 21:00 | false    |
    And following are the exceptional hours details for store <StoreId>
      | Date       | from  | till  | isClosed |
      | 2020-10-19 | 10:00 | 22:00 | false    |
    And following are the other details for store <StoreId>
      | storeOpenDate | storeCloseDate | bopisCutOffTime | timestamp     | curbSideEnabled | lockerEnabled | sddEnabled | geoFenceEnabled | parkingInformation |
      | 2020-10-19    | 0001-01-13     | 0.0             | 1603096236701 | false           | false         | false      | false           | Test             |
    Then Store should be created successfully with <StoreId> and closed status as 'false'
    Examples:
      | StoreId |
      | 1234    |