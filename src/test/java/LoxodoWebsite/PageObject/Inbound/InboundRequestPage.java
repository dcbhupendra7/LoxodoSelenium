package LoxodoWebsite.PageObject.Inbound;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import LoxodoWebsite.AbstractComponent.AbstractComponent;
import LoxodoWebsite.PageObject.ReceiveTask.ReceiveTask;

public class InboundRequestPage extends AbstractComponent {
	WebDriver driver;

	public InboundRequestPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

	}

	@FindBy(linkText = "Inbound Request")
	WebElement inboundRequest;

	@FindBy(xpath = "//span[text()='ADD']")
	WebElement inboundRequestAdd;

	@FindBy(css = ".col-md-8 input[formcontrolname='extid']")
	WebElement extid;

	@FindBy(css = ".col-md-8 input[formcontrolname='poid']")
	WebElement poid;

	@FindBy(css = "#cdk-step-content-0-0 div:nth-child(2) > div:nth-child(3) .mat-button-wrapper")
	WebElement startDate;

	@FindBy(css = "#cdk-step-content-0-0 div:nth-child(2) > div:nth-child(4) .mat-button-wrapper")
	WebElement endDate;

	@FindBy(css = ".mat-calendar-body-today")
	WebElement currentDay;

	@FindBy(xpath = "//span[text()=' Next ']")
	WebElement nextButton;

	@FindBy(xpath = "(//input[@formcontrolname='companyName'])[1]")
	WebElement shippingCompanyName;

	@FindBy(xpath = "(//input[@formcontrolname='companyName'])[2]")
	WebElement supplierCompanyName;

	@FindBy(xpath = "(//input[@formcontrolname='email'])[1]")
	WebElement shippingEmail;

	@FindBy(xpath = "(//input[@formcontrolname='email'])[2]")
	WebElement supplierEmail;

	@FindBy(css = "#cdk-step-content-0-2 .btn")
	WebElement itemAddButton;

	@FindBy(xpath = "(//input[@formcontrolname='name'])")
	List<WebElement> itemAdd;

	@FindBy(css = "input[formcontrolname='name']")
	WebElement itemField;

	@FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
	WebElement itemSelectionFromDropdown;

	@FindBy(css = "input[formcontrolname='content']")
	WebElement qtyField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;

	@FindBy(css = "th[name=\"date_created\"]")
	WebElement dateCreatedElement;

	@FindBy(xpath = "(//mat-icon[text()='exit_to_app'])[1]")
	WebElement releaseButtonElement;

	@FindBy(xpath = "//select[@formcontrolname='zoneid']")
	WebElement zoneSelectElement;

	@FindBy(css = ".animatedFast .ng-star-inserted")
	WebElement zoneSelectionWindow;

	@FindBy(xpath = "//option[@class='ng-star-inserted']")
	List<WebElement> chooseZoneFromDropdown;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement generateReceiveTask;

	@FindBy(xpath = "//button[text()='Start Receiving']")
	WebElement startReceivingButton;

	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	WebElement cancelReceiveTaskDirectly;
	
	@FindBy(xpath="//button[text()='No']")
	WebElement donotReceiveItemsFromInbound;

	public void openInboundRequestPage() {
		inboundRequest.click();
	}

	public void clickOnInboundRequestAdd() {
		inboundRequestAdd.click();
	}

	public void sendExtid(String extidValue) {
		extid.sendKeys(extidValue + getRandomString().getTime());
	}

	public void sendPoid(String poidValue) {
		poid.sendKeys(poidValue + getRandomString().getTime());
	}

	public void clickOnStartDateSelection() {
		startDate.click();
	}

	public void clickOnEndDateSelection() {
		endDate.click();
	}

	public void selectTodayFromSelection() {
		currentDay.click();
	}

	public void clickOnNextButton() {
		nextButton.click();
	}

	public void getShippingCompanyName() {
		shippingCompanyName.sendKeys(companyName);
	}

	public void getSupplierCompanyName() {
		supplierCompanyName.sendKeys(companyName);
	}

	public void getShippingEmail() {
		shippingEmail.sendKeys(email);
	}

	// to add the supplier email
	public void getSupplierEmail() {
		supplierEmail.sendKeys(email);
	}

	// click on add button to add empty line
	public void clickOnLineAddButton(int addLimit) {
		for (int i = 0; i < addLimit; i++) {
			itemAddButton.click();
		}

	}

	public void itemEnter(String itemCode) {
		itemField.sendKeys(itemCode);
	}

	// add item and select from dropdown
	public void addItemsOnRequest() {
		itemSelectionFromDropdown.click();

	}

	// Update Qty in Qty field

	public void updateQty(String qty) {
		qtyField.sendKeys(qty);
	}

	// save inbound request
	public void saveInboundRequest() {
		saveButton.click();

	}

	// sort request by created date
	public void sortByDateCreated() throws InterruptedException {
		Thread.sleep(5000);
		dateCreatedElement.click();

	}

	// release inbound request
	public void releaseInboundRequest() {
		releaseButtonElement.click();

	}

	public void clickOnZoneSelection() throws InterruptedException {
		zoneSelectElement.click();
		Thread.sleep(5000);
	}

	public void chooseZone() {
		Select select = new Select(zoneSelectElement);
		select.selectByIndex(1);
	}

	public void generateReceiveTask() {
		generateReceiveTask.click();

	}

	public ReceiveTask clickOnStartReceiving() {
		donotReceiveItemsFromInbound.click();
		ReceiveTask receiveTask = new ReceiveTask(driver);
		return receiveTask;
		
	}
	public void cancelReceiveTaskDirectly() {
		waitForElementToAppear(cancelReceiveTaskDirectly);
		cancelReceiveTaskDirectly.click();
		
	}

}
