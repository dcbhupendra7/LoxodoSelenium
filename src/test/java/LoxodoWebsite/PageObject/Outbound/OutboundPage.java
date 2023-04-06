package LoxodoWebsite.PageObject.Outbound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LoxodoWebsite.AbstractComponent.AbstractComponent;

public class OutboundPage extends AbstractComponent{
	WebDriver driver;
	public OutboundPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this );
	}
	@FindBy(linkText="Outbound")
	WebElement outbound;
	
	
	public OutboundRequestPage openOutboundPage() {
		outbound.click();
		OutboundRequestPage outboundRequestPage= new OutboundRequestPage(driver);
		return outboundRequestPage;
	}
	
}
