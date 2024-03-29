package LoxodoWebsite.PageObject.ReceiveTask;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

	@FindBy(css = ".mat-card")
	List<WebElement> receiveTasks;

	@FindBy(xpath = "//button[@mattooltip='Start']")
	List<WebElement> startButton;

	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement confirmButton;

	@FindBy(css = "#common-goods-movement-bin-scan-input")
	WebElement binScanField;

	@FindBy(css = ".box-item>.d-flex >.mr-auto")
	WebElement lineItems;

	@FindBy(xpath = "//span[text()=' Add ']")
	WebElement addButton;

	@FindBy(xpath = "//span[text()=' Confirm ']")
	WebElement confirmButtonToReceiveItem;

	@FindBy(xpath = "//span[text()='OK']")
	WebElement confirmationHeaderOkButton;
	
	@FindBy(xpath="//*[text()=' DONE']")
	WebElement receiveTaskDoneButton;
	
	@FindBy(xpath="//div[text()='Task Updated Successfully.']")
	WebElement receiveTaskComplete;

	public void clickOnReceiveTask() {
		receiveTaskElement.click();
	}


	public void selectLatestReceiveTask() {
		int totalListedTask = receiveTasks.size();
		startButton.get(totalListedTask - 1).click();
	}

	public void startReceiveTaskProcess() {
		confirmButton.click();
	}

	public void sendBinLocation() {
		binScanField.sendKeys("Z01B01");
		binScanField.sendKeys(Keys.ENTER);
	}

	public void scanLineItems() throws InterruptedException {
		waitForElementToClick(lineItems);
		lineItems.click();
	}

	public void addLineItem() {
		addButton.click();
	}

	public void confirmScannedLineItems() {
		confirmButtonToReceiveItem.click();
	}
	public void clickOkOnConfirmationHeaderOkButton() throws InterruptedException {
		Thread.sleep(5000);
		
//		waitForElementToClick(confirmationHeaderOkButton);
//		waitForElementToAppear(confirmationHeaderOkButton);
		confirmationHeaderOkButton.click();
	}
	public void clickOnReceiveTaskDoneButton() throws InterruptedException {
		Thread.sleep(5000);
//		waitForElementToClick(receiveTaskDoneButton);
		receiveTaskDoneButton.click();
	}
	
	public void receiveTaskComplete() {
		waitForElementToAppear(receiveTaskComplete);
		Assert.assertEquals(receiveTaskComplete.getText(), "Task Updated Successfully.");
		
		
		}
}
