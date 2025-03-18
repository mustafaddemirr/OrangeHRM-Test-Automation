Feature: Login Testi

  @InvalidEntry
  Scenario Outline: Hatali giris denemesi
    Given login paneline girilir
    When  "<username>" kullanici adi girilir
    When "<password>" parola girilir
    When login butonuna tiklanir
    Then "<error>" hata mesaji beklenir
    Examples:
      |username|password|error              |
      |        |        |Required           |
      |Admin   |        |Required           |
      |        |admin123|Required           |
      |abcdef  |123456  |Invalid credentials|


  @SuccessfulEntry
  Scenario Outline:Basarili giris yapma
    Given  login paneline girilir
    When  "<username>" kullanici adi girilir
    When "<password>" parola girilir
    When login butonuna tiklanir
    Then Dashboard acilmesi beklenir
    Examples:
      |username|password|
      |Admin   |admin123|













