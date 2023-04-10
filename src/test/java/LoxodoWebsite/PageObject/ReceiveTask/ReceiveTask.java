package LoxodoWebsite.PageObject.ReceiveTask;

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
	
	public void clickOnReceiveTask() {
		receiveTaskElement.click();
	}

}
