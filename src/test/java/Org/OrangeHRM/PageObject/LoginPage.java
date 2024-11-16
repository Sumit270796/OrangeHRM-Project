package Org.OrangeHRM.PageObject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver ) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "username") 
	WebElement username;	

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement LoginBtn;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement errorMessage;
	
    @FindBy(xpath =  ("//span[text() ='Required']"))
	WebElement blankUsernameMessage;
    
   @FindBy(xpath = "//span[text() ='Required']")
    WebElement blankPasswordMessage;
   
   public void enterUserName(String uname) {
		username.sendKeys(uname);	
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);	
	}
	public void clickOnLoginButton() {
		LoginBtn.click();	
	}

public String invalidCredentialMessage() {
	return errorMessage.getText();
}
public String blankUserBoxMessage() {
	return blankUsernameMessage.getText();
}

public String blankPasswordMessage() {
return blankPasswordMessage.getText();
}


}





