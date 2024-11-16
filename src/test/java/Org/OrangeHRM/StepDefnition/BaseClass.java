package Org.OrangeHRM.StepDefnition;



import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Org.OrangeHRM.PageObject.DashboardPage;
import Org.OrangeHRM.PageObject.LoginPage;
import Org.OrangeHRM.Utilities.ReadConfig;

public class BaseClass {
public static   WebDriver driver;
public LoginPage loginPg;
public ReadConfig readconfig;
public Logger logger;
public  DashboardPage dashboardPg;



}
