package LoxodoWebsite.PageObject.ReceiveTask;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	public void clickOnReceiveTask() {
		receiveTaskElement.click();
	}

//	public void binsAPIResponse() throws IOException {
//		getAllReceivingBins();
//	}
	public void selectLatestReceiveTask() {
		int totalListedTask = receiveTasks.size();
		startButton.get(totalListedTask - 1).click();
	}

	public void startReceiveTaskProcess() {
		confirmButton.click();
	}

	public void sendBinLocation() {
//		Actions action = new Actions(driver);	
		binScanField.sendKeys("Z01B01");
//		action.click(binScanField).build().perform();
		binScanField.sendKeys(Keys.ENTER);
	}

	public void scanLineItems() throws InterruptedException {
		Thread.sleep(5000);
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
		confirmationHeaderOkButton.click();
	}
	public void clickOnReceiveTaskDoneButton() throws InterruptedException {
		Thread.sleep(5000);
//		waitForElementToClick(receiveTaskDoneButton);
		receiveTaskDoneButton.click();
	}
}
