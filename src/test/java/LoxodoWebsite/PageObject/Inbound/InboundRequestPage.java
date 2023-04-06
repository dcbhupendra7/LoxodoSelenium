package LoxodoWebsite.PageObject.Inbound;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LoxodoWebsite.AbstractComponent.AbstractComponent;

public class InboundRequestPage extends AbstractComponent {
	WebDriver driver;

	public InboundRequestPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	
	@FindBy(css="input[formcontrolname='name']")
	WebElement itemField;

	@FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
	WebElement itemSelectionFromDropdown;
	
	@FindBy(css="input[formcontrolname='content']")
	WebElement qtyField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;

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
		shippingCompanyName.sendKeys(shippingCompanyNameValue);
	}

	public void getSupplierCompanyName() {
		supplierCompanyName.sendKeys(supplierCompanyNameValue);
	}

	public void getShippingEmail() {
		shippingEmail.sendKeys(shippingEmailValueValue);
	}

	// to add the supplier email
	public void getSupplierEmail() {
		supplierEmail.sendKeys(supplierEmailValue);
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
	
	//Update Qty in Qty field
	
	public void updateQty(String qty) {
		qtyField.sendKeys(qty);
	}
	
	public void saveInboundRequest()
	{
		saveButton.click();
	}

	
}
