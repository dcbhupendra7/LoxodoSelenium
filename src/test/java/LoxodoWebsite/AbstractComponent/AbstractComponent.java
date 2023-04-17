package LoxodoWebsite.AbstractComponent;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class AbstractComponent {
	WebDriver driver;

	protected String[]  regularBatchSerial= {"Regular","Batch","Serial"};
	protected String binsAPI="https://jsonplaceholder.typicode.com/posts";
	Faker faker = new Faker();
	protected String companyName=faker.company().name();
	protected String email= faker.internet().emailAddress();

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void maximizeWindow() {

		driver.manage().window().maximize();
	}

	public Timestamp getRandomString() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;

	}
	public String  getTodayDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return today.format(formatter);
    }
	public void waitForElementToAppear(WebElement webElement) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf( webElement));
	}
	public void waitForElementToClick(WebElement webElement) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6000));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		
	}
//	public void waitForElementToBeEnabled(WebElement webElement) {
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6000));
//		 wait.until(new ElementToBeEnabled(webElement));
//		
//	}
	
	
	
	
//	public void getAllReceivingBins() throws IOException {
//		URL binsUrl = new URL(binsAPI);
//		HttpURLConnection connection = (HttpURLConnection)binsUrl.openConnection();
//		connection.setRequestMethod("GET");
//		int responseCode = connection.getResponseCode();
//		System.out.println(responseCode);
//		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//		while ((inputLine = in.readLine()) != null) {
//		    response.append(inputLine);
//		}
//		in.close();
//
//	}
	


}
