@apiDemos
Feature: API Demos test
  Scenario: Wifi Text Box Data Gonderme
    Given app yuklendi
    And ana sayfada oldugunu dogrula
    Then Prefence butonuna tikla ve o sayfada oldugunu dogrula
    And Prefence dependencies butonuna tikla
    And Checkbox secili olacak
    Then WiFi setting butonuna tikla
    And Wifi settings popup geldigini dogrula
    Then text alanina data gonder
    And ok butonuna tikla