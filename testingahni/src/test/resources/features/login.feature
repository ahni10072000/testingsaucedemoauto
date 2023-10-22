Feature: Login

 Scenario: Login sebagai user name yang valid
  
  Given user harus buka menggunakan link
  When user input username dan password
  And user klik tombol login
  Then user masuk ke halaman home