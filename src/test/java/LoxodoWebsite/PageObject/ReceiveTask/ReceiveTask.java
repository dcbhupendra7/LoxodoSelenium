package LoxodoWebsite.PageObject.ReceiveTask;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LoxodoWebsite.AbstractComponent.AbstractComponent;

public class ReceiveTask extends AbstractComponent {
	WebDriver driver;

	public ReceiveTask(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a[href*=\"receive\"]")
	WebElement receiveTaskElement;
	
	@FindBy(css=".mat-card")
	List <WebElement> receiveTasks;
	
	@FindBy(xpath="//button[@mattooltip='Start']")
	List <WebElement> startButton;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement confirmButton;
	
	@FindBy(xpath="//*[text()='Warehouse Setup']")
	WebElement warehouseSetup;
	
	@FindBy(css="a[href*='/bins']")
	WebElement binPage;
	
	public void clickOnReceiveTask() {
		receiveTaskElement.click();
	}
	
//	public void binsAPIResponse() throws IOException {
//		getAllReceivingBins();
//	}
	public void selectLatestReceiveTask() {
		int totalListedTask= receiveTasks.size();
		startButton.get(totalListedTask-1).click();
	}
	
	public void startReceiveTaskProcess() {
		confirmButton.click();
	}

	public void openWarehouseSetup() {
		warehouseSetup.click();
		
	}
	public void clickOnBinsPage() {
		binPage.click();
	}
}
