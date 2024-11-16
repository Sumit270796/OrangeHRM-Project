Feature: Login Feature

Background:
 Given  User launch browser
 When  User enter Url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

             
Scenario: Login with valid credential
And    User enter Username as "Admin" and Password as "admin123"
Then   Navigate pageTitle should be "OrangeHRM" 
 And    Click on Login button
And    User click on Userdropdown tab 
And    User click on LoGOut link
Then   Navigate pageTitle should be "OrangeHRM" 
And   User close browser           


Scenario Outline: Login with invalid credential
                  And   User enter invalid Username as "<Username>" and invalid  Password as "<Password>"             
                  And    Click on Login button            
                  Then   User should see error message "Invalid credentials"
                   And   User close browser           
Examples:
|Username|Password|
|Admin|admin12|
|Admi|admin123|
|Admin|admin|
 @Sanity
Scenario:  Login with blank Username and Passsword
       When  User keeps blank Username and Password inputbox
       And   Click on Login button
       Then  User should see error message by Username and Password textbox "Required"
       And   User close browser
 

