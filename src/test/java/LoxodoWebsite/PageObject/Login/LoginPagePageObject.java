package LoxodoWebsite.PageObject.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import LoxodoWebsite.AbstractComponent.AbstractComponent;
import LoxodoWebsite.PageObject.Inbound.InboundPage;

public class LoginPagePageObject extends AbstractComponent {
	WebDriver driver;
	
	//constructor to initiate driver and page factory
	public LoginPagePageObject(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(id="mat-input-4")
	WebElement tenant;
	
	@FindBy(id="mat-input-0")
	WebElement email;
	
	@FindBy(id="mat-input-1")
	WebElement passwordElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(css=".pl10")
	WebElement errorMessage;
	
	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement dashboard;
	
	public void url() {
		driver.get("https://loxodo.tech/");
	}
	
	public InboundPage loginTOApplication(String tenantName,String username, String password) {
		tenant.sendKeys(tenantName);
		email.sendKeys(username);
		passwordElement.sendKeys(password);
		submit.click();
		InboundPage inbound=new InboundPage(driver);
		return inbound;
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void getDashboard() {
		dashboard.getText();
		Assert.assertEquals(dashboard.getText(), "Dashboard");
	}
	
}
