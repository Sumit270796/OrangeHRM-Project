package Org.OrangeHRM.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  DashboardPage {
	WebDriver ldriver;

	public DashboardPage(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath =  "//span[@class='oxd-userdropdown-tab']")
	WebElement userdropdown;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement LogOutLink;

	public void clickuserdropdown() {
		userdropdown.click();
	}

	public void clickLogOutLink() {
		LogOutLink.click();
	}}