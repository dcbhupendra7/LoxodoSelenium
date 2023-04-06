package LoxodoWebsite.AbstractComponent;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	protected String shippingCompanyNameValue="Seva Development";
	protected String supplierCompanyNameValue="Navigator Business Solutions";
	protected String shippingEmailValueValue="sevadevelopment@gmail.com";
	protected String supplierEmailValue= "navigatorbusinesssolutions@gmail.com";
	protected String[]  regularBatchSerial= {"Regular","Batch","Serial"};


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
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf( webElement));
	}
	

}
