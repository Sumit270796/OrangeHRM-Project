package Org.OrangeHRM.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	String File = "C:\\Users\\HP\\Desktop\\Maven Project\\ORANGEHRM\\Config.properties";
	Properties properties;


	public ReadConfig() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(File);
		properties.load(fis);
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}
}
