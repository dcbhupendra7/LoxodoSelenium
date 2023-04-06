package LoxodoWebsite.PageObject.Outbound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LoxodoWebsite.AbstractComponent.AbstractComponent;

public class OutboundRequestPage extends AbstractComponent{
	WebDriver driver;
	public OutboundRequestPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Outbound Request")
	WebElement outboundRequest;

	
	public void clickOnOutboundRequest() {
		outboundRequest.click();
	}
}
