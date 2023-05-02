package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import LoxodoWebsite.PageObject.Login.LoginPagePageObject;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	public WebDriver driver;
	public LoginPagePageObject loginPage;

//	@BeforeClass
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//Resources//GlobalData.properties");
		prop.load(file);
		String browserName=	System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");

		// to use chrome driver
		if (browserName.contains("chrome")) {

//			driver = new ChromeDriver();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			//to run in headless mode
			if(browserName.contains("headless")){
				chromeOptions.addArguments("headless");
//				driver = new ChromeDriver(chromeOptions);

			}


			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
		}
//		to use firefox driver
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		//to use edge driver
		else if(browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {

				});
		return data;
	}

	// to take screenshot
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	@BeforeTest(alwaysRun = true)
	public LoginPagePageObject gotoWebsite() throws IOException {
		driver = initializeDriver();
		loginPage = new LoginPagePageObject(driver);
		loginPage.url();
		return loginPage;
	}
	@AfterTest
	public void closeApplication()
	{
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);

	}


}
