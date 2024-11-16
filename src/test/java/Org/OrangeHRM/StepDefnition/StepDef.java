package Org.OrangeHRM.StepDefnition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Org.OrangeHRM.PageObject.DashboardPage;
import Org.OrangeHRM.PageObject.LoginPage;
import Org.OrangeHRM.Utilities.ReadConfig;
import io.cucumber.java.en.*;


public class StepDef extends BaseClass {
	@Given("User launch browser")
	public void user_launch_browser() throws Exception {

		readconfig = new ReadConfig();
		logger = LogManager.getLogger("StepDef");
		String browser = readconfig.getBrowser();


		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else throw  new Exception("Browser not found");
		logger.info("launch browser");
	}


	@When("User enter Url {string}")
	public void user_enter_url(String Url) {
		driver.get(Url);
	}

	@When("User enter Username as {string} and Password as {string}")
	public void user_enter_username_as_and_password_as(String uname, String pwd) {
		loginPg = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 logger.info("Enter valid username and password");
		loginPg.enterUserName(uname);
		loginPg.enterPassword(pwd);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		logger.info("Click on login button");
		loginPg.clickOnLoginButton();
	}

	@Then("Navigate pageTitle should be {string}")
	public void navigate_page_title_should_be(String Pagetitle) {
      logger.info("User navigate to dashborad page");		
      Assert.assertEquals(Pagetitle,"OrangeHRM" );
	}

	@Then("User click on Userdropdown tab")
	public void user_click_on_userdropdown_tab() {
		logger.info("User click on userdropdown tab");
		dashboardPg = new DashboardPage(driver);
		dashboardPg.clickuserdropdown();

	}

	@Then("User click on LoGOut link")
	public void user_click_on_lo_g_out_link() {
		 logger.info("User click on LogOutLink");
		dashboardPg.clickLogOutLink();
	}



	@When("User enter invalid Username as {string} and invalid  Password as {string}")
	public void user_enter_invalid_username_as_and_invalid_password_as(String Username, String Password) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		loginPg = new LoginPage(driver);
		logger.info("User enter invalid username and password");
		loginPg.enterUserName(Username);
		Thread.sleep(3000);
		loginPg.enterPassword(Password);
		Thread.sleep(3000);
	}


	@Then("User should see error message {string}")
	public void user_should_see_error_message(String errorMessage) {
		String ActualMessage = loginPg.invalidCredentialMessage();
		Assert.assertEquals(ActualMessage, errorMessage);
	    logger.info("User should see an error message Invalid credential");
	}

	@When("User keeps blank Username and Password inputbox")
	public void user_keeps_blank_username_and_password_inputbox() {
		loginPg = new LoginPage(driver);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  logger.info("User keeps blank username and password");
	}
	@Then("User should see error message by Username and Password textbox {string}")
	public void user_should_see_error_message_by_username_and_password_textbox(String  blankerrorMessage) {
		String ActualMessage =   loginPg.blankPasswordMessage();
		Assert.assertEquals(ActualMessage, blankerrorMessage);
      logger.info("User should see message Required");
	}


	@Then("User close browser")
	public void user_close_browser() {
		logger.info("User close browser");
		driver.quit();

	}}
