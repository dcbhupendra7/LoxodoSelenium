package LoxodoWebsite.PageObject.Inbound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LoxodoWebsite.AbstractComponent.AbstractComponent;

public class InboundPage extends AbstractComponent{
	WebDriver driver;
	public InboundPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(className="inbound")
	WebElement inbound;
	
	
	
	public InboundRequestPage openInboundPage() {
		inbound.click();
		InboundRequestPage inboundRequest=new InboundRequestPage(driver);
		return inboundRequest;
	}
	
	
}
