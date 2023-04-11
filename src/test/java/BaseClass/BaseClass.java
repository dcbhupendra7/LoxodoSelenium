package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import LoxodoWebsite.PageObject.Login.LoginPagePageObject;

public class BaseClass {
	public WebDriver driver;
	public LoginPagePageObject loginPage;

//	@BeforeClass
	public WebDriver initializeDriver() throws IOException {
//		Properties prop = new Properties();
//		FileInputStream stream = new FileInputStream(
//				System.getProperty("user.dir") + "//Loxodo//src//test//java//Resources//GlobalData.properties");
//		FileInputStream stream = new FileInputStream("C:\\Users\\bhupe\\OneDrive\\Desktop\\Loxodo\\src\\test\\java\\Resources\\GlobalData.properties");
//		prop.load(stream);
//		String browserName = prop.getProperty("browser");

		String browserName="chrome";
		// to use chrome driver
		if (browserName.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
		}
//		to use firefox driver
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		return driver;
	}
	@BeforeClass(alwaysRun=true)
	public LoginPagePageObject gotoWebsite() throws IOException {
		driver = initializeDriver();
		loginPage = new LoginPagePageObject(driver);
		loginPage.url();
		return loginPage;
	}
//	@AfterClass
//	public void closeApplication()
//	{
//		driver.quit();
//		Reporter.log("=====Browser Session End=====", true);
//		
//	}

}
