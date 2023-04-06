package LoxodoWebsite.Loxodo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import LoxodoWebsite.AbstractComponent.AbstractComponent;
import LoxodoWebsite.PageObject.Inbound.InboundPage;
import LoxodoWebsite.PageObject.Inbound.InboundRequestPage;
import LoxodoWebsite.PageObject.Login.LoginPagePageObject;
import LoxodoWebsite.PageObject.Outbound.OutboundPage;
import LoxodoWebsite.PageObject.Outbound.OutboundRequestPage;

public class LoxodoLogin extends BaseClass {
	@Test
	public void inboundRequest() throws IOException {
		{
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
//		LoginPagePageObject login= new LoginPagePageObject(driver);
//		AbstractComponent abstractcomponent = new AbstractComponent(driver);
//		abstractcomponent.maximizeWindow();
//		login.url();
//			 loginPage = gotoWebsite();
			InboundPage inbound = loginPage.loginTOApplication("soundcore", "bhupendra@soundcore.com", "bhupendra");
			OutboundPage outbound= new OutboundPage(driver);
//		InboundPage inbound = new InboundPage(driver);
			InboundRequestPage inboundRequest = inbound.openInboundPage();
//		InboundRequestPage inboundRequest= new InboundRequestPage(driver);
			inboundRequest.openInboundRequestPage();
			inboundRequest.clickOnInboundRequestAdd();
			inboundRequest.sendExtid("inboundExtid-");
			inboundRequest.sendPoid("inboundPoid-");
			inboundRequest.clickOnStartDateSelection();
			inboundRequest.selectTodayFromSelection();
			inboundRequest.clickOnEndDateSelection();
			inboundRequest.selectTodayFromSelection();
			inboundRequest.clickOnNextButton();
			inboundRequest.getShippingCompanyName();
			inboundRequest.getSupplierCompanyName();
			inboundRequest.getShippingEmail();
			inboundRequest.getSupplierEmail();
			inboundRequest.clickOnNextButton();
			inboundRequest.clickOnLineAddButton(1);
			inboundRequest.itemEnter("Regular");
			inboundRequest.addItemsOnRequest();
			inboundRequest.updateQty("100");
			inboundRequest.saveInboundRequest();
			OutboundRequestPage outboundPage= outbound.openOutboundPage();
			outboundPage.clickOnOutboundRequest();
//			driver.close();
		}
	}

}
